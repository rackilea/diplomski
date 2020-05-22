/*
* Herkunft/Origin: http://javacrypto.bplaced.net/
* Programmierer/Programmer: Michael Fehr
* Copyright/Copyright: frei verwendbares Programm (Public Domain)
* Copyright: This is free and unencumbered software released into the public domain.
* Lizenttext/Licence: <http://unlicense.org>
* getestet mit/tested with: Java Runtime Environment 8 Update 191 x64
* Datum/Date (dd.mm.jjjj): 19.11.2019 
* Funktion: verschlüsselt einen string im aes ctr modus pkcs5padding mit jce
*           entschlüsselt einen string im aes ctr modus nopadding mit bc
* Function: encrypts a string using aes ctr modus with pkcs5padding using JCE
*           decrypts a string using aes ctr modus nopadding using BC
*
* Hinweis: die JCE arbeitet immer im NOPADDING-Modus, egal was alternativ angegeben ist ! 
* Notice: JCE works always in NOPADDING mode and not in PKCS5PADDING even if named !
* Link: http://bouncy-castle.1462172.n4.nabble.com/SunJCE-versus-BouncyCastle-using-AES-CTR-PKCS5Padding-td1465907.html
* 
* Sicherheitshinweis/Security notice
* Die Programmroutinen dienen nur der Darstellung und haben keinen Anspruch auf eine 
* korrekte Funktion, insbesondere mit Blick auf die Sicherheit ! 
* Prüfen Sie die Sicherheit bevor das Programm in der echten Welt eingesetzt wird.
* The program routines just show the function but please be aware of the security part - 
* check yourself before using in the real world !
*/

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class AesCtrNoPaddingRandomString {

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException,
            InvalidAlgorithmParameterException, NoSuchProviderException {
        System.out.println("AES mode CTR PKCS5PADDING or NOPADDING ?");

        Security.addProvider(new BouncyCastleProvider());

        String plaintextString = "HelloWorld12345"; // hier 15 zeichen
        String decryptedtextString = ""; // enthält später den entschlüsselten text
        final byte[] keyByte = "12345678901234567890123456789012".getBytes("UTF-8"); // 32 byte
        // random iv, 16 bytes long
        final byte[] initvectorByte = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(initvectorByte);

        byte[] plaintextByte = plaintextString.getBytes("UTF-8");
        byte[] ciphertextByte = null;
        byte[] decryptedtextByte = null;

        // encryption
        ciphertextByte = AesCtrPkcs5PaddingEncrypt(plaintextByte, keyByte, initvectorByte);
        // decryption with bouncy castle
        decryptedtextByte = AesCtrNoPaddingDecryptBC(ciphertextByte, keyByte, initvectorByte);
        // decrypted text
        decryptedtextString = new String(decryptedtextByte, "UTF-8");
        // output
        System.out.println("");
        System.out.println("keyByte (hex)          :" + printHexBinary(keyByte));
        System.out.println("initvectorByte (hex)   :" + printHexBinary(initvectorByte));
        System.out.println("plaintextString        :" + plaintextString);
        System.out.println("plaintextByte (hex)    :" + printHexBinary(plaintextByte));
        System.out.println("= = = Encryption AES/CTR/PKCS5PADDING JCE = = =");
        System.out.println("ciphertextByte (hex)   :" + printHexBinary(ciphertextByte));
        System.out.println("= = = Decryption AES/CTR/NOPADDING BC = = =");
        System.out.println("decryptedtextByte (hex):" + printHexBinary(decryptedtextByte));
        System.out.println("decryptedtextString    :" + decryptedtextString);
    }

    public static byte[] AesCtrPkcs5PaddingEncrypt(byte[] plaintextByte, byte[] keyByte, byte[] initvectorByte)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
            InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        byte[] ciphertextByte = null;
        SecretKeySpec keySpec = new SecretKeySpec(keyByte, "AES");
        IvParameterSpec ivKeySpec = new IvParameterSpec(initvectorByte);
        Cipher aesCipherEnc = Cipher.getInstance("AES/CTR/PKCS5PADDING");
        aesCipherEnc.init(Cipher.ENCRYPT_MODE, keySpec, ivKeySpec);
        ciphertextByte = aesCipherEnc.doFinal(plaintextByte);
        return ciphertextByte;
    }

    public static byte[] AesCtrNoPaddingDecryptBC(byte[] ciphertextByte, byte[] keyByte, byte[] initvectorByte)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
            InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException,
            NoSuchProviderException {
        byte[] decryptedtextByte = null;
        SecretKeySpec keySpec = new SecretKeySpec(keyByte, "AES");
        IvParameterSpec ivKeySpec = new IvParameterSpec(initvectorByte);
        Cipher aesCipherDec = Cipher.getInstance("AES/CTR/NOPADDING", "BC");
        aesCipherDec.init(Cipher.DECRYPT_MODE, keySpec, ivKeySpec);
        decryptedtextByte = aesCipherDec.doFinal(ciphertextByte);
        return decryptedtextByte;
    }

    public static byte[] AesCtrNoPaddingDecrypt(byte[] ciphertextByte, byte[] keyByte, byte[] initvectorByte)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
            InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        byte[] decryptedtextByte = null;
        SecretKeySpec keySpec = new SecretKeySpec(keyByte, "AES");
        IvParameterSpec ivKeySpec = new IvParameterSpec(initvectorByte);
        Cipher aesCipherDec = Cipher.getInstance("AES/CTR/NOPADDING");
        aesCipherDec.init(Cipher.DECRYPT_MODE, keySpec, ivKeySpec);
        decryptedtextByte = aesCipherDec.doFinal(ciphertextByte);
        return decryptedtextByte;
    }

    public static String printHexBinary(byte[] bytes) {
        final char[] hexArray = "0123456789ABCDEF".toCharArray();
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
}