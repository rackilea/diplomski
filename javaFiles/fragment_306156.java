public class Login extends HttpServlet {
...
    HttpSession session = request.getSession();
    Map<String,Object> values = session.GetAll(); //This line is psydo code
    //Use getValueNames() and a loop with getValue(String name);

    // Kill the current session
   session.invalidate();

   HttpSession newSession = request.getSession(true);
   newSession.putAllValues(values); //This line is psydo code
...