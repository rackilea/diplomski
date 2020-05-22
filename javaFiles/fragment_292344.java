public class MyServlet extends HttpServlet {
    static {
        Class.forName("com.mysql.jdbc.Driver");
    }

    // ...
}