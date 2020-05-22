@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.setAttribute("salute", "Hello world from Servlet!");
        request.getRequestDispatcher("/realView.jsp").forward(request, response);
    }
}