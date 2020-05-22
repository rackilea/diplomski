@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    private ServletContext sc;    // delay initialization to init

    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        sc = this.getServletContext();
    }