@POST
@Path("/test/{personId}/{addressId}")
public void createUser(@Form MyForm form)
{
    System.out.println(form.toString());
}