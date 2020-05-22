import static java.nio.charset.StandardCharsets.UTF_8;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.File;
import java.io.FileReader;
import java.math.BigInteger;
import java.security.spec.X509EncodedKeySpec;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class VerifySig {

    public static RSAPublicKey fromPKCS1Encoding(byte[] pkcs1EncodedPublicKey) {
        // --- parse public key ---
        org.bouncycastle.asn1.pkcs.RSAPublicKey pkcs1PublicKey;
        try {
            pkcs1PublicKey = org.bouncycastle.asn1.pkcs.RSAPublicKey
                    .getInstance(pkcs1EncodedPublicKey);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    "Could not parse BER PKCS#1 public key structure", e);
        }

        // --- convert to JCE RSAPublicKey
        RSAPublicKeySpec spec = new RSAPublicKeySpec(
                pkcs1PublicKey.getModulus(), pkcs1PublicKey.getPublicExponent());
        KeyFactory rsaKeyFact;
        try {
            rsaKeyFact = KeyFactory.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("RSA KeyFactory should be available", e);
        }
        try {
            return (RSAPublicKey) rsaKeyFact.generatePublic(spec);
        } catch (InvalidKeySpecException e) {
            throw new IllegalArgumentException(
                    "Invalid RSA public key, modulus and/or exponent invalid", e);
        }
    }


    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());

    String pkey = fromFile("pub_verify_key.txt");
        byte[] dpkey = Base64.decodeBase64(pkey);
        RSAPublicKey publicKey = fromPKCS1Encoding(dpkey);
        String plainData = fromFile("plain.txt");
        String data = fromFile("signedkey.txt");
        byte[] ciphertext = Base64.decodeBase64(data);
        System.out.println(new String(plainData.getBytes(), UTF_8));
        verifyBC(publicKey, plainData, ciphertext);
        System.out.flush();
    }

    private static void verifyBC(PublicKey publicKey, String plainData,
            byte[] ciphertext) throws Exception {
        // what should work (for PKCS#1 v1.5 signatures), requires Bouncy Castle provider
        //Signature sig = Signature.getInstance( "SHA256withRSAandMGF1");
        Signature sig = Signature.getInstance( "SHA256withRSA");
        sig.initVerify(publicKey);
        sig.update(plainData.getBytes(UTF_8));
        System.out.println(sig.verify(ciphertext));
    }

    private static String fromFile(String filename) {
        StringBuilder builder = new StringBuilder(8000);
        try {
            FileReader reader = new FileReader(new File(filename));
            int c;
            while((c = reader.read()) != -1) {
                builder.append((char)c);
            }
        } catch(IOException ioe) {
            throw new RuntimeException(ioe);
        }
        return builder.toString();
    }
}