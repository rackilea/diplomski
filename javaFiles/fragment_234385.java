@Path("orders")
public class OrderService {

    @GET
    @Path("{orderId}/completed")
    public String getOrders(@PathParam("orderId") String orderId) {
        return "orderId: " + orderId;
    }

    @GET
    @Path("summary")
    public String getOrdersSummary() {
        return "orders summary";
    }
}