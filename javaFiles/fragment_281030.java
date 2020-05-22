public class LoginToWebsiteUtil  {
   private static Connection conn = null;
   public static final void login(String username, String password, ...)  {
      conn = getConnectionFromLogin(username, password);

      //and so on...