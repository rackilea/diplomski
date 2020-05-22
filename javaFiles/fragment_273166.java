public class MyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("nameOne");
        System.out.println("<form action='Myservlet.do' method='get'>");
        System.out.println("nameOne is " + name);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("nameThree");
        System.out.println("<form action='Myservlet.do' method='post'>");
        System.out.println("nameThree is " + name);
    }

}