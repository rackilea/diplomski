public class PageController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("page", "/WEB-INF" + request.getPathInfo());
        request.getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);
    }

}