package webapp
public class servlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ClassA.doGet(req,resp);
    }
}