@Path("/customers")
public class CustomerService  {
    private Service service; 

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getAllCustomersService() {
        return (ArrayList<Customer>) service.getAllCustomers();
    }
...