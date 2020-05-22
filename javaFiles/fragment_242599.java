public class EntryServlet extends HttpServlet {

   public final void doGet(HttpServletRequest request, HttpServletResponse response
   ) throws ServletException, IOException {
    String forwardURL = request.getParameter("param");
    response.sendRedirect( forwardURL );
  }

}