@WebServlet("/ComponentServlet")
  public class ComponentInitializator extends HttpServlet{
    @Inject
    private ServletContext context;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
                      throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        out.println(context);
    }
 }