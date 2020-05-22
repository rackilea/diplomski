@WebServlet("/employees")
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TableData tbd=new TableData();
        List<Employee> listOfEmp=tbd.getAllEMployees();        
        request.setAttribute("listOfEmp", listOfEmp);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/emloyee.jsp");
        rd.forward(request, response);
    }

}