// resource method
@POST
@Consumes(MediaType.APPLICATION_XML)
public Response getResponse(Customer customer) { ... }

// some model class
@XmlRootElement
public class Customer { ... }

// client request
Customer customer = new Customer();
Response response = target.request().post(Entity.xml(customer));