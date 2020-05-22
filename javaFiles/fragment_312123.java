public class YourServlet extends HttpServlet {

    @Override
    public void init() throws ServletException { 
         ServletContext ctx = getServletContext(); 
         // ...
    } 

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
         ServletContext ctx = getServletContext(); 
         // ...
    } 

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
         ServletContext ctx = getServletContext(); 
         // ...
    } 

}