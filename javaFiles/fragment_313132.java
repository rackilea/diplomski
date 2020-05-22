@WebServlet("/users/*")
public class UsersController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] pathInfo = request.getPathInfo().split("/");
        String id = pathInfo[1]; // {id}
        String command = pathInfo[2]; // a or b
        // ...
    }

}