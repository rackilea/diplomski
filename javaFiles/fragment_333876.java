public class BasicTotoServlet extends HttpServlet {
 /**
  * Manage GET HTTP Request
  */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String data = getData();
        request.setAttibute("sSearch_0", data)
    }
}