@WebServlet("/bar") //your URL pattern
public class DummyServlet extends HttpServlet {

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher("/path/to/foo.jsp").forward(request, response);
}