public class MyServlet extends HttpServlet {

    @Resource(name = "jdbc/MyDataSource")
    private DataSource dataSource;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // dataSource may be accessed directly here since the container will automatically
        // inject an instance of the data source when the servlet is initialized

}