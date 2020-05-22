import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import javax.xml.bind.DatatypeConverter;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;

public class Crypto {
    private static final char[] tempKey = new char[] {'T', 'E', 'M', 'P', '_', 'G', 'E', 'N', '_', 'K', 'E', 'Y'};
    private static final SecureRandom secureRandomForSalt = new SecureRandom();
    private static final SecureRandom secureRandomForIV = new SecureRandom();

    private static byte[] generateSalt() throws RuntimeException {
        try{
            byte[] saltBytes = new byte[32];

            secureRandomForSalt.nextBytes(saltBytes);

            return saltBytes;
        }
        catch(Exception ex){
            ex.printStackTrace();
            throw new RuntimeException("An error occurred in salt generation part. Reason: " + ex.getMessage());
        }
    }

    public static String enc(String content) throws RuntimeException {
        String encClassMethodNameForLogging = Crypto.class.getName() + ".enc" + " || ";

        byte[] salt;
        byte[] encodedTmpSecretKey;
        SecretKeySpec keySpec;
        Cipher cipher;
        byte[] iv;
        IvParameterSpec ivParameterSpec;
        String finalEncResult;

        if(content == null || content.trim().length() == 0) {
            throw new RuntimeException("To be encrypted text is null or empty");
        }

        System.out.println("-- Encrypting -----------");

        try {
            salt = generateSalt();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(encClassMethodNameForLogging + "An error occurred in salt generation part. Reason: " + ex.getMessage());
        }

        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(Crypto.tempKey, salt, 65536, 256);
            SecretKey tmpSecretKey = factory.generateSecret(spec);

            encodedTmpSecretKey = tmpSecretKey.getEncoded();
            System.out.println("-- Secret Key Derivation in Encryption: " + Base64.getEncoder().encodeToString(encodedTmpSecretKey));
        }
        catch (NoSuchAlgorithmException ex){
            ex.printStackTrace();
            throw new RuntimeException(encClassMethodNameForLogging + "An error occurred in key derivation part. Reason: " + ex.getMessage() + " - Explanation: The particular cryptographic algorithm requested is not available in the environment");
        }
        catch (InvalidKeySpecException ex){
            ex.printStackTrace();
            throw new RuntimeException(encClassMethodNameForLogging + "An error occurred in key derivation part. Reason: " + ex.getMessage() + " - Explanation: Key length may not be correct");
        }
        catch (Exception ex){
            ex.printStackTrace();
            throw new RuntimeException(encClassMethodNameForLogging + "An error occurred in key derivation part. Reason: " + ex.getMessage());
        }

        try {
            keySpec = new SecretKeySpec(encodedTmpSecretKey, "Blowfish");
            cipher = Cipher.getInstance("Blowfish/CBC/PKCS5Padding");
        }
        catch (NoSuchAlgorithmException ex){
            ex.printStackTrace();
            throw new RuntimeException(encClassMethodNameForLogging + "An error occurred in cipher instantiation part. Reason: " + ex.getMessage() + " - Explanation: The particular cryptographic algorithm requested is not available in the environment");
        }
        catch (NoSuchPaddingException ex){
            ex.printStackTrace();
            throw new RuntimeException(encClassMethodNameForLogging + "An error occurred in cipher instantiation part. Reason: " + ex.getMessage() + " - Explanation: The particular padding mechanism is requested but is not available in the environment");
        }
        catch (Exception ex){
            ex.printStackTrace();
            throw new RuntimeException(encClassMethodNameForLogging + "An error occurred in cipher instantiation part. Reason: " + ex.getMessage());
        }

        try {
            iv = new byte[cipher.getBlockSize()];
            secureRandomForIV.nextBytes(iv);
            ivParameterSpec = new IvParameterSpec(iv);
        }
        catch (Exception ex){
            ex.printStackTrace();
            throw new RuntimeException(encClassMethodNameForLogging + "An error occurred in iv creation part. Reason: " + ex.getMessage());
        }

        try {
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParameterSpec);
            byte[] encoding = cipher.doFinal(content.getBytes("UTF-8"));

            String encCon = DatatypeConverter.printBase64Binary(encoding);
            String ivStr = DatatypeConverter.printBase64Binary(iv);
            String saltStr = DatatypeConverter.printBase64Binary(salt);

            System.out.println("-- encCon : " + encCon);
            System.out.println("-- iv : " + ivStr);
            System.out.println("-- salt : " + saltStr);

            finalEncResult = encCon + ":" + ivStr + ":" + saltStr;
            System.out.println("-- finalEncRes : " + finalEncResult + "\n");
        }
        catch (InvalidKeyException ex){
            ex.printStackTrace();
            throw new RuntimeException(encClassMethodNameForLogging + "An error occurred in encryption part. Reason: " + ex.getMessage() + " - Explanation: Most probably you didn't download and copy 'Java Cryptography Extension (JCE) Unlimited Strength Jurisdiction Policy Files'");
        }
        catch (InvalidAlgorithmParameterException ex){
            ex.printStackTrace();
            throw new RuntimeException(encClassMethodNameForLogging + "An error occurred in decryption part. Reason: " + ex.getMessage() + " - Explanation: IV length may not be correct");
        }
        catch (IllegalBlockSizeException ex){
            ex.printStackTrace();
            throw new RuntimeException(encClassMethodNameForLogging + "An error occurred in decryption part. Reason: " + ex.getMessage() + " - Explanation: The length of data provided to a block cipher is incorrect, i.e., does not match the block size of the cipher");
        }
        catch (BadPaddingException ex){
            ex.printStackTrace();
            throw new RuntimeException(encClassMethodNameForLogging + "An error occurred in encryption part. Reason: " + ex.getMessage() + " - Explanation: A particular padding mechanism is expected for the input data but the data is not padded properly (Most probably wrong/corrupt key caused this)");
        }
        catch (UnsupportedEncodingException ex){
            ex.printStackTrace();
            throw new RuntimeException(encClassMethodNameForLogging + "An error occurred in encryption part. Reason: " + ex.getMessage() + " - Explanation: The Character Encoding is not supported");
        }
        catch (Exception ex){
            ex.printStackTrace();
            throw new RuntimeException(encClassMethodNameForLogging + "An error occurred in encryption part. Reason: " + ex.getMessage());
        }

        return finalEncResult;
    }

    public static String dec(String encContent) throws RuntimeException {
        String decClassMethodNameForLogging = Crypto.class.getName() + ".dec" + " || ";

        String decCon;
        byte[] salt;
        byte[] encodedTmpSecretKey;
        SecretKeySpec keySpec;
        Cipher cipher;
        byte[] iv;

        if(encContent == null || encContent.trim().length() == 0) {
            throw new RuntimeException("To be decrypted text is null or empty");
        }

        System.out.println("-- Decrypting -----------");

        try {
            salt = DatatypeConverter.parseBase64Binary(encContent.substring(encContent.lastIndexOf(":") + 1));
        }
        catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(decClassMethodNameForLogging + "An error occurred in salt retrieving part. Reason: " + ex.getMessage());
        }

        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(Crypto.tempKey, salt, 65536, 256);
            SecretKey tmpSecretKey = factory.generateSecret(spec);

            encodedTmpSecretKey = tmpSecretKey.getEncoded();
            System.out.println("-- Secret Key Gathering in Decryption: " + Base64.getEncoder().encodeToString(encodedTmpSecretKey));
        }
        catch (NoSuchAlgorithmException ex){
            ex.printStackTrace();
            throw new RuntimeException(decClassMethodNameForLogging + "An error occurred in key derivation part. Reason: " + ex.getMessage() + " - Explanation: The particular cryptographic algorithm requested is not available in the environment");
        }
        catch (InvalidKeySpecException ex){
            ex.printStackTrace();
            throw new RuntimeException(decClassMethodNameForLogging + "An error occurred in key derivation part. Reason: " + ex.getMessage() + " - Explanation: Key length may not be correct");
        }
        catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(decClassMethodNameForLogging + "An error occurred in key derivation part. Reason: " + ex.getMessage());
        }

        try {
            keySpec = new SecretKeySpec(encodedTmpSecretKey, "Blowfish");
            cipher = Cipher.getInstance("Blowfish/CBC/PKCS5Padding");
        }
        catch (NoSuchAlgorithmException ex){
            ex.printStackTrace();
            throw new RuntimeException(decClassMethodNameForLogging + "An error occurred in cipher instantiation part. Reason: " + ex.getMessage() + " - Explanation: The particular cryptographic algorithm requested is not available in the environment");
        }
        catch (NoSuchPaddingException ex){
            ex.printStackTrace();
            throw new RuntimeException(decClassMethodNameForLogging + "An error occurred in cipher instantiation part. Reason: " + ex.getMessage() + " - Explanation : The particular padding mechanism requested is not available in the environment");
        }
        catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(decClassMethodNameForLogging + "An error occurred in cipher instantiation part. Reason: " + ex.getMessage());
        }

        try {
            iv = DatatypeConverter.parseBase64Binary(encContent.substring(encContent.indexOf(":") + 1, encContent.lastIndexOf(":")));
        }
        catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(decClassMethodNameForLogging + "An error occurred in iv creation part. Reason: " + ex.getMessage());
        }

        try {
            cipher.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(iv));
            byte[] decoding = cipher.doFinal(Base64.getDecoder().decode(encContent.substring(0, encContent.indexOf(":"))));

            decCon = new String(decoding, "UTF-8");
            System.out.println("-- decCon : " + decCon + "\n");
        }
        catch (InvalidKeyException ex){
            ex.printStackTrace();
            throw new RuntimeException(decClassMethodNameForLogging + "An error occurred in decryption part. Reason: " + ex.getMessage() + " - Explanation: Most probably you didn't download and copy 'Java Cryptography Extension (JCE) Unlimited Strength Jurisdiction Policy Files'");
        }
        catch (InvalidAlgorithmParameterException ex){
            ex.printStackTrace();
            throw new RuntimeException(decClassMethodNameForLogging + "An error occurred in decryption part. Reason: " + ex.getMessage() + " - Explanation: IV length may not be correct");
        }
        catch (IllegalBlockSizeException ex){
            ex.printStackTrace();
            throw new RuntimeException(decClassMethodNameForLogging + "An error occurred in decryption part. Reason: " + ex.getMessage() + " - Explanation: The length of data provided to a block cipher is incorrect, i.e., does not match the block size of the cipher");
        }
        catch (BadPaddingException ex){
            ex.printStackTrace();
            throw new RuntimeException(decClassMethodNameForLogging + "An error occurred in encryption part. Reason: " + ex.getMessage() + " - Explanation: A particular padding mechanism is expected for the input data but the data is not padded properly (Most probably wrong/corrupt key caused this)");
        }
        catch (UnsupportedEncodingException ex){
            ex.printStackTrace();
            throw new RuntimeException(decClassMethodNameForLogging + "An error occurred in encryption part. Reason: " + ex.getMessage() + " - Explanation: The Character Encoding is not supported");
        }
        catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(decClassMethodNameForLogging + "An error occurred in decryption part. Reason: " + ex.getMessage());
        }

        return decCon;
    }

    public static void main(String args[]) {
        System.out.println("-- Original -------------");
        String plainText = "hello world";
        System.out.println("-- origWord : " + plainText + "\n");

        String e = Crypto.enc(plainText);
        String d = Crypto.dec(e);

        System.out.println("-- Results --------------");
        System.out.println("-- PlainText: " + plainText);
        System.out.println("-- EncryptedText: " + e);
        System.out.println("-- DecryptedText: " + d);
    }
}