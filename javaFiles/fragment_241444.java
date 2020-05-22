@WebServlet("/*")
public class ExampleServlet extends javax.servlet.http.HttpServlet {
    @Resource(lookup = "jdbc/myOracleDataSource")
    private DataSource dataSource;

    public void init() throws ServletException {
        // Here is another way of accessing the data source - via JNDI lookup.
        // This requires the jndi-1.0 feature
        DataSource anotherDataSource = InitialContext.doLookup("jdbc/myOracleDataSource");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            conn = dataSource.getConnection();
            System.out.println("connection established");
            response.getWriter().println("connection established");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("failed to establish connection: " + e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}