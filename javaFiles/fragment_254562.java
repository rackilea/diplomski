public abstract class DatabaseInvokerServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AbstractUser currentUser = request.getSession().getAttribute("user");
        // Keep the variables in the method block! 
        // Do not assign them as instance variable!
    }
}