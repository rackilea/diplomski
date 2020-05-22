public class CustomerResource {
    @PUT
    @Path("{id}")
    public Response updateCustomer(Customer customer) {}
    @POST
    @Path("{id}")
    public Response createCustomer(Customer customer) {}
}