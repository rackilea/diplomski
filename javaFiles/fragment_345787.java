public class AdditionServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException {
        String x = request.getParameter("x");
        String y = request.getParameter("y");
        if (x == null || y == null) throw new ServletException();
        try {
            request.setAttribute("result", 
                Integer.parseInt(x) + Integer.parseInt(y));
        } catch (NumberFormatException ex) {
            throw new ServletException(ex);
        }
        request.getRequestDispatcher("/WEB-INF/jsp/calc.jsp")
            .forward(request, response);
    }
}