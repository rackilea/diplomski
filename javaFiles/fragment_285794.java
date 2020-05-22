@WebServlet(urlPatterns = {"/list2json"})
public class list2json extends HttpServlet 
{

   @Override
public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

   try {
      List<String> foo = new ArrayList<String>();
      foo.add("A");
       foo.add("B");
      foo.add("C");

      String json = new Gson().toJson(foo);

    } catch (Exception ex) {
      ex.printStackTrace();
   }
}