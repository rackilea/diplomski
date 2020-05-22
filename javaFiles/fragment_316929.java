@Path("/SignIn")
@GET
@Produces("text/html")
public String SignIn(@QueryParam("username") String username, @QueryParam("password") String password, @QueryParam("extension") String extension) {

    //TODO return proper representation object
    return "Credentials  " + username + " : " + password + " : " + extension;
}