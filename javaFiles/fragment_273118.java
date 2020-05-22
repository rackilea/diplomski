@WebServlet("/AuthServlet")
public class AuthServlet 
    extends HttpServlet {
//  .. lines omitted ..

   @Override
   protected final void doPost(HttpServletRequest request,
           HttpServletResponse response) throws ServletException,IOException {

      // ... lines omitted 

      // perform authentication with JAAS
      try {
         LoginContext loginContext = new LoginContext("SomeName", handler);
         // starts the actual login
         loginContext.login();

         //at this point, user is authenticated..normally you would forward him to e.g. a jsp, welcoming the user
         //request.getRequestDispatcher("anyJsp.jsp").forward(request, response);

         //but you can also forward to another serlvet and perform business logic or else
         request.getRequestDispatcher("/ServletName").forward(request, response); 

      } catch (LoginException e) {
         //do sth., if auth fails
      }
 }