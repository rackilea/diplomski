import javax.xml.bind.DatatypeConverter;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        String s = "ü";
        MessageDigest sha1 = MessageDigest.getInstance("SHA1");
        for (Map.Entry<String, Charset> entry : Charset.availableCharsets().entrySet()) {
            try {
                byte[] encoded = s.getBytes(entry.getValue());
                byte[] digest = sha1.digest(encoded);
                System.out.printf("For encoding %s, SHA1 hash is %s%n",
                        entry.getKey(), DatatypeConverter.printHexBinary(digest));
            } catch (UnsupportedOperationException e) {
                System.out.printf("Cant make it work for %s%n", entry.getKey());
            }
        }
    }

}