@Path("/movies")
public class MovieResource {

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getMovieList() {
        MovieList list = new MovieList();
        list.add(new Movie("I Origins"));
        list.add(new Movie("Imitation Game"));
        return Response.ok(list).build();
    }
}