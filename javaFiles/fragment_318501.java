@GET
@Path("{orderid}/")
@Produces({"application/xml","application/json"})
public Order status(@PathParam("orderid") long orderId){
   return delivery.status(orderId);
}