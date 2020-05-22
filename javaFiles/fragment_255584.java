@GET
@Produces("text/plain")
@Path("/")
public String getFoo(@QueryParam("foo") String id) {
    // ...
}