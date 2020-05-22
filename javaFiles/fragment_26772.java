public class MyServlet extends HttpServlet {
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws IOException, ServletException {

    String fname = req.getParameter("fname");
    // db code here

    PrintWriter out = resp.getWriter();
    out.print("All done!");
  }
}