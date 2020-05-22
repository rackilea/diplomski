@WebServlet("/UserController")
public class UserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
        IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/test.jsp");
        rd.forward(request, response);
    }
}