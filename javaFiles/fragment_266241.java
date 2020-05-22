package chaCha20Poly1305Encryption;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class ChaCha20Poly1305KeyGenerator {
    public static SecretKey generateKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("ChaCha20");
        //Keysize MUST be 256 bit - as of Java11 only 256Bit is supported
        keyGenerator.init(256);
        return keyGenerator.generateKey();
    }
    public static void main(String[] args) throws NoSuchAlgorithmException {
        SecretKey key = generateKey();
        System.out.println(key.getAlgorithm() + " SecretKey: " + Base64.getEncoder().encodeToString(key.getEncoded()));
    }
}