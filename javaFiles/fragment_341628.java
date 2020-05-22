@Path("/foo")
public class MyResourceClass {

    @GET
    @Path("/bar")
    public String myResourceMethod(@BeanParam ParameterAggregator params) {
        ...
    }
}