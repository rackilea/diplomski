public class main {

/**
 * @param args
 * @throws AuthenticationFault
 */
public static void main(String[] args) throws AuthenticationFault {
  // TODO Auto-generated method stub
  Class cls = org.alfresco.repo.security.authentication.AuthenticationException.class;
  ProtectionDomain pDomain = cls.getProtectionDomain();
  CodeSource cSource = pDomain.getCodeSource();
  URL loc = cSource.getLocation();
  System.out.println(loc);
}