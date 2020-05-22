import static java.nio.charset.StandardCharsets.*;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class Test {
    private static String getSecurePassword(String password, String salt, String algo)
            throws NoSuchAlgorithmException, InvalidKeyException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(salt.getBytes(UTF_8), algo);
        Mac mac = Mac.getInstance(algo);
        mac.init(secretKeySpec);
        byte[] bytes = mac.doFinal(password.getBytes(UTF_8));

        return new BigInteger(1, bytes).toString(16);
    }

    public static void main(String[] args)
            throws NoSuchAlgorithmException, InvalidKeyException {
        System.out.println(getSecurePassword("test", "test", "HmacSHA512"));
    }
}