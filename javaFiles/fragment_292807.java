@WebServlet("/BrightSymphonyController")
public class BrightSymphonyController extends HttpServlet {
/**
 * @see HttpServlet#HttpServlet()
 */
public BrightSymphonyController() {
    //super();
    // TODO Auto-generated constructor stub
}
/**
 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse       response)
 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    String deleteuser = request.getParameter("delete");
        System.out.println("deleteuser============"+deleteuser);
        String id=request.getParameter("id");
        System.out.println("id============"+id);
}
/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        }
}