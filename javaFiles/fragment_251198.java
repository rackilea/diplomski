@WebServlet(name = "updaterServlet", urlPatterns = { "/backEnd" })
public class UpdaterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;UTF-8");

        PrintWriter writer = response.getWriter();
        writer.write(new java.util.Date().toString());
        writer.close();
    }

    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
         doGet(request, response);
    }   
}