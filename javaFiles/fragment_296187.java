@WebServlet({ "/LoginServlet", "/" })
public class LoginServlet extends HttpServlet 
{
    private static final long serialVersionUID = 1L;

    private Connection conn;

    @Resource(lookup="jdbc/SQL-RCT")
    private DataSource myDataSource;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            conn = myDataSource.getConnection();
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}