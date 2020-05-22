@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        // Prepare messages.
        request.setAttribute("name", name);
        request.getRequestDispatcher("/WEB-INF/hello.jsp").forward(request, response);
    }
}