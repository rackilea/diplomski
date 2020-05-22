public class WorkerServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
    String target = req.getParameter("target");

    // do something

    resp.setStatus( resp.SC_OK );

  }

}