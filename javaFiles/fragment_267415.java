@GET
@Produces( { MediaType.APPLICATION_XML })
@Path("/customers/{id}")
public Customer getCustomer(@PathParam("id") int id) {
    ...
    return customer;
}