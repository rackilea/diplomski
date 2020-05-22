@SlingServlet(metatype = true, resourceTypes = {"/apps/sling/servlet/errorhandler"}, extensions = {"404"})
public class ErrorServlet extends SlingSafeMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        RequestDispatcher dispatcher = request.getRequestDispatcher("myPath");
        dispatcher.include(request,response);
    }
}