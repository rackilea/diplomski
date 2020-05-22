public class MyServiceImpl implements IMyService {

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_XML)
    public String sayHello(@PathParam("name") final String name) {
        return "Hello " + name + " !!";
    }
}