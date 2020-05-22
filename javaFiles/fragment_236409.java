@POST
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Path("insertt")
public void insert(@FormParam("id") Integer id,
                   @FormParam("name") String name,
                   @FormParam("lastname") String lastname,
                   @FormParam("adress") String adress,
                   @FormParam("city") String city ) {

Customer cust = new Customer();
cust.setCustomerId(id);
...
customerDAO.add( cust );