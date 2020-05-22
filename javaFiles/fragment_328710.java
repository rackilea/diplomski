@WebServlet("/activate")
public class ActivationServlet extends HttpServlet {

   @EJB
   private ActivationService service;

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String key = request.getParameter("key");

       // ...

       response.sendRedirect(request.getContextPath() + "/login.xhtml");
   }

}