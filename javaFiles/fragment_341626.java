@Path("/foo")
public class MyResourceClass {

    @QueryParam("nationality")
    @DefaultValue("nationality")
    private String nationality;

    @QueryParam("experience")
    @DefaultValue("experience")
    private String experience;

    @QueryParam("empid")
    @DefaultValue("empid")
    private String empid;

    @GET
    @Path("/bar")
    public String myResourceMethod() {
        ...
    }
}