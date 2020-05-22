public class SmtpAuthenticator extends Authenticator {
public SmtpAuthenticator() {

    super();
}

@Override
public PasswordAuthentication getPasswordAuthentication() {
 String username = "user";
 String password = "password";
    if ((username != null) && (username.length() > 0) && (password != null) 
      && (password.length   () > 0)) {

        return new PasswordAuthentication(username, password);
    }

    return null;
}