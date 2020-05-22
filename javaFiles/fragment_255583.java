@GET
@Produces("text/plain")
@Path("/foo/{fooID}")
public String getFoo(@PathParam("fooID") String id) {
    // ...
}