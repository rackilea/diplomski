@Path("/foo")
public class MyResourceClass {

    @GET
    @Path("/bar")
    public String myResourceMethod(
        @QueryParam("nationality") @DefaultValue("nationality") String nationality, 
        @QueryParam("experience") @DefaultValue("experience") String experience,
        @QueryParam("empid") @DefaultValue("empid") String empid) {

        ...
    }
}