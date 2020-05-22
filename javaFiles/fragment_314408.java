public class UpdateServlet extends HttpServlet {

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    response.setContentType("text/html");

    System.out.println(request.getParameter("input_id"));
    System.out.println(request.getParameter("input_name"));
    System.out.println(request.getParameter("input_beschreibung"));

    RequestDispatcher rd=request.getRequestDispatcher("LoadServlet");  
    rd.forward(request, response);

}