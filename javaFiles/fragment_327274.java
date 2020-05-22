public class NoIFrameAllowedServlet extends HttpServlet {

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
      response.setHeader("X-Frame-Options", "SAMEORIGIN");
    }