import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import javax.xml.bind.DatatypeConverter;
import java.security.SecureRandom;
import javax.crypto.spec.IvParameterSpec;

public class Crypto {
    public static String enc(String content, String key) {
        String encCon = "";
        String ivStr = "";

        try {
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes("UTF-8"), "Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish/CBC/PKCS5Padding");

            byte[] iv = new byte[cipher.getBlockSize()];
            SecureRandom secureRandom = new SecureRandom();
            secureRandom.nextBytes(iv);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

            String secret = content;
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParameterSpec);
            byte[] encoding = cipher.doFinal(secret.getBytes("UTF-8"));

            System.out.println("-- Encrypted -----------");
            encCon = DatatypeConverter.printBase64Binary(encoding);
            ivStr = DatatypeConverter.printBase64Binary(iv);
            System.out.println("-- encCon : " + encCon);
            System.out.println("-- iv : " + ivStr);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return encCon + ":" + ivStr;
    }

    public static String dec(String encContent, String key) {
        String decCon = "";

        try {
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes("UTF-8"), "Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish/CBC/PKCS5Padding");

            byte[] iv = DatatypeConverter.parseBase64Binary(encContent.substring(encContent.indexOf(":") + 1));

            String secret = encContent.substring(0, encContent.indexOf(":"));
            cipher.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(iv));
            byte[] decoding = cipher.doFinal(Base64.getDecoder().decode(secret));

            System.out.println("-- Decrypted -----------");
            decCon = new String(decoding, "UTF-8");
            System.out.println("-- decCon : " + decCon);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return decCon;
    }

    public static void main(String args[]) {
        String e = Crypto.enc("hello world", "key123");
        String d = Crypto.dec(e, "key123");
    }
}