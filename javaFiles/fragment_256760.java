import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class ObservableMovieRepository implements MovieRepository {

    private final MovieRepository repository ;
    private final ObservableList<Movie> movieList;


    public ObservableMovieRepository(MovieRepository repository) {
        this.repository = repository ;
        this.movieList = FXCollections.observableArrayList(repository.getAll());
    }

    @Override
    public void add(Movie movie) {
        repository.add(movie);
        movieList.add(movie);
    }

    @Override
    public void remove(String title) {
        Movie movie = get(title);
        repository.remove(title);
        movieList.remove(title);
    }

    @Override
    public void remove(int index) {
        repository.remove(index);
        movieList.remove(index);
    }

    @Override
    public Movie get(String title) {
        return repository.get(title);
    }

    @Override
    public Movie get(int index) {
        return movieList.get(index);
    }

    @Override
    public ObservableList<Movie> getAll() {
        return movieList ;
    }

}