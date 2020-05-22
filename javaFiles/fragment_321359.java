@WebServlet(name = "MyServlet", urlPatterns = {"/myservlet"})
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("<html><head>"+
        "<script type=\"text/javascript\">"+
        "function cc()"+
        "{alert("+new Date()+")}"+
        "</script>"+
        "</head>"+
        "<body>"+
        "<input type='button' value='click me money' onclick='cc()'>"+
        "</body>"+
        "</html>");
    }   
}