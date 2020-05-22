@GET
@Produces(value = { "text/plain"})
@Path("{customerName}")
public Response getCustomerByName(@PathParam("customerName") String customerName) {
    System.out.println(customerName);
    return Response.ok().entity(customerName).type("text/plain").build();
}