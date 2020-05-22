import org.apache.commons.codec.binary.Base64;

public class B64Test {

    public static void main(String[] args) {
        byte[] plaintext = new byte[100];
        String b64text = new Base64().encodeAsString(plaintext);
        System.out.println(b64text);
    }
}