@Path("customers")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class CustomerResource {

    @GET
    @Path("{customerId}")
    public CustomerModel getCustomer(@PathParam("customerId") Long id) {
        ...
    }

    @GET
    @Path("{customerId}/details")
    public CustomerDetailModel getCustomerDetail(@PathParam("customerId") Long id) {
        ...
    }
}