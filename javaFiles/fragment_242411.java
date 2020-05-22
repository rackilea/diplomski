@Path("/root/path")
public class RootResource {
    @Path("/sub/path")
    public SubResource doSomething() {
       // return an instance of your sub resource
    }
}

@Produces(MediaType.TEXT_XML, MediaType.APPLICATION_JSON)
public class SubResource {
    @GET
    @Path("/")
    public Collection<SomeBean> getAll() {}

    @GET
    @Path("/{id}
    public SomeBean getSingle() {}

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public SomeBean reallyDoSomething(@FormParam("param1") final String param) {
       // do ... something
    }
}