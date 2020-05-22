public class myServlet extends HttpServlet {
     x xx = new x();
     ...
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
     ...
     xx.doSomething(); // concurrency race 
     xx.var1 = varA;   // concurrency race 
     ...
    }