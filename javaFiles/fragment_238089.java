@WebServlet("/YourServlet")
public class YourServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
        int stock = Integer.parseInt(request.getParameter("stock"));
        TelevisionShopClient client = new TelevisionShopClient("...");
        //complete the logic...
    }
}