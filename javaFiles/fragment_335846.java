public class SomeServlet extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String userAgentString = request.getHeader("User-Agent");
      UserAgent userAgent = UserAgent.parseUserAgentString(userAgentString);
      OperatingSystem os = userAgent.getOperatingSystem();

      // Do stuff with os...
  }
}