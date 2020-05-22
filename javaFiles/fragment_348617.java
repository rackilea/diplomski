import java.util.ArrayList;
    import java.util.List;
    import java.util.ListIterator;


    public class MovieListExample {

        List<Movie> movies = new ArrayList<>();

        public class Movie {

            int id;
            Genre genre;

            public Movie(int id, Genre genre)
            {
                this.id = id;
                this.genre = genre;
            }

            @Override
            public String toString()
            {
                return "Movie{" + "id=" + id + ", genre=" + genre + '}';
            }

        }

        public enum Genre {

            NON_FICTION,
            GENERAL_FICTION,
            SCIENCE_FICTION,
            WESTERN
        }

        public void loadInMovie(Genre genre, int amount)
        {
            for (int x = 0; x < amount; x++) {
                movies.add(new Movie(x, genre));
            }
        }

        public Movie removeLastMovieWithGenre(Genre genre)
        {
            ListIterator<Movie> iterator = movies.listIterator(movies.size());
            while (iterator.hasPrevious()) {
                Movie movie = iterator.previous();
                if (genre.equals(movie.genre)) {
                    iterator.remove();
                    return movie;
                }
            }
            throw new RuntimeException("No movie found"); // or return null, or change return type to boolean or void.
        }



        public static void main(String[] args)
        {
            MovieListExample movieListExample = new MovieListExample();
            movieListExample.loadInMovie(Genre.NON_FICTION, 3);
            movieListExample.loadInMovie(Genre.GENERAL_FICTION, 3);
            movieListExample.loadInMovie(Genre.SCIENCE_FICTION, 3);
            movieListExample.loadInMovie(Genre.WESTERN, 3);

            System.out.println("SciFi movies in collection");
            movieListExample.movies.stream().filter(movie -> movie.genre.equals(Genre.SCIENCE_FICTION)).forEach(movie -> System.out.println(movie));

            Movie removeLastMovieWithGenre = movieListExample.removeLastMovieWithGenre(Genre.SCIENCE_FICTION);
            System.out.println("Removed " + removeLastMovieWithGenre);
            System.out.println("Remains in collection");
            movieListExample.movies.stream().filter(movie -> movie.genre.equals(Genre.SCIENCE_FICTION)).forEach(movie -> System.out.println(movie));
        }
    }