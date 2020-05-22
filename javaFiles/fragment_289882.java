@Path("user")
public class UserResource {

    @CurrentUser 
    private User user;

    @GET
    public Response getCurrentUser() {
        return Response.ok(user.getUsername()).build();
    }
}