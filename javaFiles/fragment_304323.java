@Path("/movies")
public class MovieResource extends AbstractResource<Movie, MovieDto> {

    public MovieResource(MovieRepository repository) {
        super(repository, Movie.class, MovieDto.class);
    }
}