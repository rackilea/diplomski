import java.net.Authenticator;
import java.net.PasswordAuthentication;


public class MyAuthenticator extends Authenticator {
    private String username;
    private String password;

    public MyAuthenticator(String username, String password){
        this.username = username;
        this.password = password;
    }

    public PasswordAuthentication getPasswordAuthentication () {
        return new PasswordAuthentication (username, password.toCharArray());
    }
}