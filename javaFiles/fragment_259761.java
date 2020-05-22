package example;
import java.util.Arrays;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.generators.OpenSSLPBEParametersGenerator;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.BlockCipherPadding;
import org.bouncycastle.crypto.paddings.PKCS7Padding;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;

public class OpenSSLAesDecrypter
{
    private static final int AES_NIVBITS = 128; // CBC Initialization Vector (same as cipher block size) [16 bytes]

    private final int keyLenBits;

    public OpenSSLAesDecrypter(int nKeyBits)
    {
        this.keyLenBits = nKeyBits;
    }

    public byte[] decipher(byte[] pwd, byte[] src)
    {
        // openssl non-standard extension: salt embedded at start of encrypted file
        byte[] salt = Arrays.copyOfRange(src, 8, 16); // 0..7 is "SALTED__", 8..15 is the salt

        try
        {
            // Encryption algorithm. Note that the "strength" (bitsize) is controlled by the key object that is used.
            // Note that PKCS5 padding and PKCS7 padding are identical.
            BlockCipherPadding padding = new PKCS7Padding();
            BufferedBlockCipher cipher = new PaddedBufferedBlockCipher(new CBCBlockCipher(new AESEngine()), padding);

            CipherParameters params = getCipherParameters(pwd, salt);
            cipher.reset();
            cipher.init(false, params);

            int buflen = cipher.getOutputSize(src.length - 16);
            byte[] workingBuffer = new byte[buflen];
            int len = cipher.processBytes(src, 16, src.length - 16, workingBuffer, 0);
            len += cipher.doFinal(workingBuffer, len);

            // Note that getOutputSize returns a number which includes space for "padding" bytes to be stored in.
            // However we don't want these padding bytes; the "len" variable contains the length of the *real* data
            // (which is always less than the return value of getOutputSize.
            byte[] bytesDec = new byte[len];
            System.arraycopy(workingBuffer, 0, bytesDec, 0, len);
            return bytesDec;
        }
        catch (InvalidCipherTextException e)
        {
            System.err.println("Error: Decryption failed");
            return null;
        }
        catch (RuntimeException e)
        {
            System.err.println("Error: Decryption failed");
            return null;
        }
    }

    private CipherParameters getCipherParameters(byte[] pwd, byte[] salt)
    {
        // Use bouncycastle implementation of openssl non-standard (pwd,salt)->(key,iv) algorithm.
        // Note that if a "CBC" cipher is selected, then an IV is required as well as a key. When using a password,
        // Openssl
        // *derives* the IV from the (pwd,salt) pair at the same time as it derives the key.
        //
        // * PBE = Password Based Encryption
        // * CBC = Cipher Block Chaining (ie IV is needed)
        //
        // Note also that when the IV is derived from (pwd, salt) the salt **must** be different for each message; this is
        // the default for openssl - just make sure to NOT explicitly provide a salt, or encryption security is badly
        // affected.
        OpenSSLPBEParametersGenerator gen = new OpenSSLPBEParametersGenerator();
        gen.init(pwd, salt);
        CipherParameters cp = gen.generateDerivedParameters(keyLenBits, AES_NIVBITS);
        return cp;
    }

    public static void main(String[] args)
    {
        OpenSSLAesDecrypter d = new OpenSSLAesDecrypter(128);
        String r = new String(d.decipher("mypassword".getBytes(),
                Base64.decodeBase64("U2FsdGVkX187CGv6DbEpqh/L6XRKON7uBGluIU0nT3w=")));
        System.out.println(r);
    }
}