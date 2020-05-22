//GET method to print JSON 
@Path("/say")
@GET
@Produces({MediaType.APPLICATION_JSON})
public String hello()
{
    return "{\"message\":\"hello\"}";

}