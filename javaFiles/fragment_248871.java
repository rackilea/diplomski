import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import java.security.*;
import java.io.UnsupportedEncodingException;

public class EncryptDecrypt1 {

    public static void main(String[] args) throws Exception {
        EncryptDecrypt1 a = new EncryptDecrypt1();
        String encrypted = a.encrypt("My text");
        System.out.println(encrypted);      
    }
    public String encrypt(String cleartext) throws Exception {

        try 
        {
            // encoding format needs thought
            byte[] clearTextbytes = cleartext.getBytes("UTF-8");
            final SecureRandom secureKeyRandomness = SecureRandom.getInstanceStrong();
            final KeyGenerator AES_keyInstance = KeyGenerator.getInstance("AES");
            AES_keyInstance.init(128, secureKeyRandomness);
            final SecretKey secretKey = AES_keyInstance.generateKey();
            final Cipher AES_cipherInstance = Cipher.getInstance("AES/GCM/NoPadding");
            AES_cipherInstance.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedText = AES_cipherInstance.doFinal(clearTextbytes);

            byte[] iv = AES_cipherInstance.getIV();
            byte[] message = new byte[12 + clearTextbytes.length + 16];
            System.arraycopy(iv, 0, message, 0, 12);
            System.arraycopy(encryptedText, 0, message, 12, encryptedText.length);

            return decrypt(message, secretKey);
        } 
        catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | UnsupportedEncodingException e) 
        {
            e.printStackTrace();
        }
        return "something went wrong with encrypt";
    } // encrypt.

    public String decrypt(byte[] encryptedText, SecretKey secretKey) throws Exception {
        try 
        {
            final Cipher AES_cipherInstance = Cipher.getInstance("AES/GCM/NoPadding");
            GCMParameterSpec params = new GCMParameterSpec(128, encryptedText, 0, 12);
            AES_cipherInstance.init(Cipher.DECRYPT_MODE, secretKey, params);
            byte[] decryptedText = AES_cipherInstance.doFinal(encryptedText, 12, encryptedText.length - 12);
            return new String(decryptedText, "UTF-8");
        } 
        catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | UnsupportedEncodingException e) 
        {
            e.printStackTrace();
        }
        return "something went wrong with decrypt";
    }

}