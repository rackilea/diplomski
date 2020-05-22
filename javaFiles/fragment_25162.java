CREATE AND COMPILE JAVA SOURCE NAMED GetWindowUsername AS
public class GetWindowUsername {
  public static String getUsername()
  {
    return java.lang.System.getProperty("user.name");
  }
}