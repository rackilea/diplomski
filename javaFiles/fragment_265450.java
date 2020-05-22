@Override
public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, java.io.IOException {
    //make sure this is the path of the page you want/need to show
    String path = "/register.jsp";
    RequestDispatcher dis = request.getRequestDispatcher(path);
    dis.forward(request, response);
}