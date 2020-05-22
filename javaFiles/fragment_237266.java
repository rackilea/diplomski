import java.security.SecureRandom;
import org.mindrot.jbcrypt.BCrypt;
public class RandTest {
    public static void main(String[] args) {
        SecureRandom sr = new SecureRandom();
        int out = 0;
        String password = "very-strong-password-1729";
        String hashed;
        for (int i = 0; i < 200000 ; i++) {
            hashed = BCrypt.hashpw(password, BCrypt.gensalt());
            //If we print, we're generating entroy :) System.out.println(hashed);
        }
    }
}