@Path("/messages")
public class MessageResource {

    @GET
    @Path("/{id}")
    public Response getMessage(@PathParam("id") int id) {
        return Response.ok("messages, id: " + id).build();
    }

    @Path("/{id}/comments")
    public CommentsResource getComments() {
        return new CommentsResource();
    }

    public class CommentsResource {

        @GET
        @Path("/{id}")
        public Response getComment(@PathParam("id") int id) {
            return Response.ok("Hello Sub-Resource Locators").build();
        }
    }
}