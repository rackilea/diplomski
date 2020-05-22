public class OurSecure extends Controller {

  @Before(unless={"login", "authenticate", "logout"})
  static void checkAccess() throws Throwable {
    // Authent
    if(!session.contains("username")) {

        // __ my modification __ :
        flash.keep(); 


        flash.put("url", "GET".equals(request.method) ? request.url : "/");
        // seems a good default
        login();
    }

  ...
}