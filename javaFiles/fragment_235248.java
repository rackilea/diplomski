@Path("/resources")
public class Resources {
    @GET
    @Path("/resourceOne")
    @AnnotationForResourceOne
    public String getResourceOne() {...}
}