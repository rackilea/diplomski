@GET
@Path("/get")
@Produces(MediaType.APPLICATION_JSON)
public String someMethod(@SSOAuthorization String auth) {
    return auth;
}