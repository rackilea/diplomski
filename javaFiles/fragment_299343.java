@POST
Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
public Response createObject(@HeaderParam("token") String token, User o) {
    System.out.println("token: " + token);
    // ...
}