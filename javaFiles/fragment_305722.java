import org.apache.commons.codec.binary.Base64;
import org.apache.shiro.crypto.AesCipherService;

public class Test {

    public static void main(String[] args) throws Exception {
        System.out.println(encrypt("Hello"));
    }

    static String encrypt(String input) throws Exception {
        AesCipherService aesCipher = new AesCipherService();
        aesCipher.setModeName("ECB");
        byte[] bytes = aesCipher.encrypt(input.getBytes("UTF-8"), "0123456789abcdef".getBytes()).getBytes();
        byte[]   bytesEncoded = Base64.encodeBase64(bytes); 
        return new String(bytesEncoded);
    }
}