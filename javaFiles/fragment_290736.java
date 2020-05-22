@WebServlet("/someservlet/*")
public class TestServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Hello Test");
        String json = "Hello from servlet";
        try {
            response.getWriter().write(json);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}