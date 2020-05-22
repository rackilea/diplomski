@ApplicationPath("webresources")
@Path("/people")
@Stateless
public class PersonResource extends Application
{
 ...
 @GET
    @Path("/getpeople")
    @Produces(
    {
        MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML
    })
  ...