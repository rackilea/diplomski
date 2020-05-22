@Path("/rest")
@Stateless
public class RESTService {
    @GET
    @Path("/user/{user}")
    @Produces(MediaType.APPLICATION_XML)
    public User getUser(@PathParam("user") String userName);

    @GET
    @Path("/user/{user}/tweets")
    @Produces(MediaType.APPLICATION_XML)
    public Collection<Tweet> getTweets(@PathParam("user") String userName);
}