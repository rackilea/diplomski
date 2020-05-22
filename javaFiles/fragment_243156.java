@Path("/hello")
public class Hello {
    ... /* GET/PUT/POST */

    @GET
    @Path("{id}")
    public String myMethod(@PathParam("id") String id) {...}
}