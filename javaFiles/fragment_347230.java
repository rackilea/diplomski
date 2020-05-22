import java.security.Principal;
import org.apache.catalina.realm.JDBCRealm;
public class BCryptRealm extends JDBCRealm
{
  @Override
  public Principal authenticate(String username, String credentials)
  {
    String hashedPassword = getPassword(username);
    // Added this check after discovering checkpw generates a null pointer
    // error if the hashedPassword is null, which happens when the user doesn't
    // exist. I'm assuming returning null immediately would be bad practice as
    // it would let an attacker know which users do and don't exist, so I added
    // a call to hashpw. No idea if that completely solves the problem, so if
    // your application has more stringent security needs this should be
    // investigated further.
    if (hashedPassword == null)
    {
      BCrypt.hashpw("fakePassword", BCrypt.gensalt());
      return null;
    }
    if (BCrypt.checkpw(credentials, hashedPassword))
    {
      return getPrincipal(username);
    }
    return null;
  }
}