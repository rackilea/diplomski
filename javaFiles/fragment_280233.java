@WebServlet(name = "PaidOrderController", urlPatterns = {"/PaidOrderController"})
public class PaidOrderController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PaidOrder po;
        List<PaidOrder> listPaidOrder= new ArrayList<>();

        String[] pid = request.getParameterValues("id");
        String[] pname = request.getParameterValues("pname");
        String[] quantity = request.getParameterValues("quantity");
        String[] price = request.getParameterValues("price");
        String[] status = request.getParameterValues("status");
        String[] user_email = request.getParameterValues("user_email");

        String address = request.getParameter("address");           

        for(int i = 0; i < pid.length; i++){
            po = new PaidOrder();
            po.setId(pid[i]);
            po.setPname(pname[i]);
            po.setQuantity(quantity[i]);
            po.setPrice(price[i]);
            po.setStatus(status[i]);                
            po.setUser_email(user_email[i]);

            listPaidOrder.add(po);
        }

        PaidOrderDAO.paidOrder(listPaidOrder, address);
    }
}