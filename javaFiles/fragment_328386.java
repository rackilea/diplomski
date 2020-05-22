import android.util.Base64
import static java.nio.charset.StandardCharsets.UTF_8;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESCrypt {
  private static final String TRANSFORMATION = "AES/GCM/NoPadding";

  public static String encrypt(String value) throws Exception {
    Key key = generateKey();
    Cipher cipher = Cipher.getInstance(TRANSFORMATION);
    cipher.init(Cipher.ENCRYPT_MODE, key);
    byte[] encryptedByteValue = cipher.doFinal(value.getBytes(UTF_8));
    return Base64.encodeToString(encryptedByteValue, Base64.DEFAULT);
  }

  public static String decrypt(String value) throws Exception {
    Key key = generateKey();
    Cipher cipher = Cipher.getInstance(TRANSFORMATION);
    cipher.init(Cipher.DECRYPT_MODE, key);
    byte[] decryptedValue64 = Base64.decode(value, Base64.DEFAULT);
    byte[] decryptedByteValue = cipher.doFinal(decryptedValue64);
    return new String(decryptedByteValue, UTF_8);
  }

  private static Key generateKey() {
    return new SecretKeySpec(Configuration.getKey().getBytes(UTF_8), TRANSFORMATION);
  }
}