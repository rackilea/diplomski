public interface XClient {  

@GET
@Path("/api/x.json")
@Produces(MediaType.APPLICATION_JSON)
public String getMovieInformation(
        @QueryParam("q") String title,

}