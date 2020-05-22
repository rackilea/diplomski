package chaCha20Poly1305Encryption;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;

public class ChaCha20Poly1305 {

public static byte[] encrypt(byte[] data, SecretKey key) throws NoSuchPaddingException, NoSuchAlgorithmException,
        InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
    if(key == null) throw new InvalidKeyException("SecretKey must NOT be NULL");

    byte[] nonceBytes = new byte[12];

    // Get Cipher Instance
    Cipher cipher = Cipher.getInstance("ChaCha20-Poly1305/None/NoPadding");

    // Create IvParamterSpec
    AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec(nonceBytes);

    // Create SecretKeySpec
    SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "ChaCha20");

    // Initialize Cipher for ENCRYPT_MODE
    cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParameterSpec);

    // Perform Encryption
    return cipher.doFinal(data);
}

public static byte[] decrypt(byte[] cipherText, SecretKey key) throws Exception {
    if(key == null) throw new InvalidKeyException("SecretKey must NOT be NULL");
    byte[] nonceBytes = new byte[12];

    // Get Cipher Instance
    Cipher cipher = Cipher.getInstance("ChaCha20-Poly1305/None/NoPadding");

    // Create IvParamterSpec
    AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec(nonceBytes);

    // Create SecretKeySpec
    SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "ChaCha20");

    // Initialize Cipher for DECRYPT_MODE
    cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParameterSpec);

    // Perform Decryption
    return cipher.doFinal(cipherText);
}

public static void main(String[] args) throws Exception {
    SecretKey key = ChaCha20Poly1305KeyGenerator.generateKey();

    String testMessage = "hallo!";
    byte[] encryptedBytes = encrypt(testMessage.getBytes(), key);
    String decryptedMessage = new String(decrypt(encryptedBytes,key));
    System.out.println("testMessage: " + testMessage);
    System.out.println(key.getAlgorithm() + " SecretKey: " + Base64.getEncoder().encodeToString(key.getEncoded()));
    System.out.println("encryptedBytes: " + Base64.getEncoder().encodeToString(encryptedBytes));
    System.out.println("decryptedMessage: "+ decryptedMessage);

}
}