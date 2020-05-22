public class SrvData extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if ( action.equals("getStatus") ) {
           // run some query
        }
        else if ( action.equals("getUsers") ) {
           // run some query
        }
        response.getWriter().write(gson.toJson(data));
    }
}