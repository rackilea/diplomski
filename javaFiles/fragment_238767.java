@Path("/builder")
@Produces(MediaType.APPLICATION_JSON)
public class BuilderResource {


    @POST
    @Path("/test")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response test(BaseMessage<Content> testContent) {

        System.out.println("hit normal content");
        return Response.ok().build();
    }


    @POST
    @Path("/test2")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response test2(BaseMessage<Content2> testContent) {

        System.out.println("hit String content");
        return Response.ok().build();
    }
}