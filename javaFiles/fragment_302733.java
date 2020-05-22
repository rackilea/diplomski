import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;

class AES
{
    public AES()
    {
    }

    public String encrypt(String plainText, String keyBase64, String ivBase64) throws Exception
    {
        byte[] plainTextArray = plainText.getBytes(StandardCharsets.UTF_8);
        byte[] keyArray = DatatypeConverter.parseBase64Binary(keyBase64);
        byte[] iv = DatatypeConverter.parseBase64Binary(ivBase64);

        SecretKeySpec secretKey = new SecretKeySpec(keyArray, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");   
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(iv));
        return new String(DatatypeConverter.printBase64Binary(cipher.doFinal(plainTextArray)));
    }

    public String decrypt(String messageBase64, String keyBase64, String ivBase64) throws Exception {

        byte[] messageArray = DatatypeConverter.parseBase64Binary(messageBase64);
        byte[] keyArray = DatatypeConverter.parseBase64Binary(keyBase64);
        byte[] iv = DatatypeConverter.parseBase64Binary(ivBase64);

        SecretKey secretKey = new SecretKeySpec(keyArray, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(iv));
        return new String(cipher.doFinal(messageArray));
    }

    public static void main(String[] args) {

        try
        {   
            String plainText = "Hello world!";
            String encryptionKeyBase64 = "DWIzFkO22qfVMgx2fIsxOXnwz10pRuZfFJBvf4RS3eY=";
            String ivBase64 = "AcynMwikMkW4c7+mHtwtfw==";

            AES AES = new AES();

            String cipherText = AES.encrypt(plainText, encryptionKeyBase64, ivBase64);
            String decryptedCipherText = AES.decrypt(cipherText, encryptionKeyBase64, ivBase64);

            System.out.println("Plaintext: " + plainText);
            System.out.println("Ciphertext: " + cipherText);
            System.out.println("Decrypted text: " + decryptedCipherText);
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }
}