@WebServlet(name = "/servlet123", urlPatterns = { "/servlet123" })
public class Servlet123 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.write("<h2>Hello Friends! Welcome to the world of servlet annotation </h2>");
        out.write("<br/>");
        out.close();
    }
}