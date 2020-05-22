public class MovieDB {

private static ArrayList<Movie> allMovies = new ArrayList<>(12);

public static ArrayList<Movie> getAllMovies() {
    allMovies.add(new Movie("Citizen Kane", "drama"));
    allMovies.add(new Movie("Casablanca", "drama"));
    allMovies.add(new Movie("The Wizard Of Oz", "musical"));
    allMovies.add(new Movie("Singin' In The Rain", "musical"));
    allMovies.add(new Movie("Star Wars", "scifi"));
    allMovies.add(new Movie("2001: A Space Odyssey", "scifi"));
    allMovies.add(new Movie("Psycho", "horror"));
    allMovies.add(new Movie("King Kong", "horror"));
    allMovies.add(new Movie("Annie Hall", "comedy"));
    allMovies.add(new Movie("M*A*S*H", "comedy"));
    allMovies.add(new Movie("Lion King", "animated"));
    allMovies.add(new Movie("Fantasia", "animated"));

    return allMovies;
}

public static ArrayList<Movie> getMovies(String category) {
    if (allMovies.isEmpty()) {
        // Lazy initialize allMovies
        getAllMovies();
    }

    ArrayList<Movie> movies = new ArrayList<>();
    // Here I need code to return only movies from a specific category
    // From input from the user in the main
    if (category == null) {
        return movies;
    }

    for (Movie movie : allMovies) {
        if (movie.getCategory().equals(category)) {
            movies.add(movie);
        }
    }

    return movies;
}
}