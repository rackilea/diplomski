class Movie {

    String title;

    public Movie(String title) {
        this.title = title;
    }
    // equals, hashCode, toString
}

class Catalog {

    public static final List<Movie> moviesAvailable = new ArrayList<>();
    public static final List<Movie> moviesRented = new ArrayList<>();
}

class Customer {

    private List<Movie> currentlyRented = new ArrayList<>();
    private List<Movie> rentingHistory = new ArrayList<>();

    public void rentMovie(String title) {
        Movie movie = new Movie(title);
        if (Catalog.moviesAvailable.remove(movie)) {
            Catalog.moviesRented.add(movie);
            currentlyRented.add(movie);
            System.out.println("Movie " + movie + " was rented to " + this);
        } else {
            System.out.println("Movie " + movie + " is not available");
        }
    }

    public void returnMovie(String title) {
        Movie movie = new Movie(title);
        if (currentlyRented.remove(movie)) {
            rentingHistory.add(movie);
            Catalog.moviesRented.remove(movie);
            Catalog.moviesAvailable.add(movie);
            System.out.println("Movie " + movie + " was returned by " + this);
        } else {
            System.out.println("Movie " + movie + " is not being rented by " + this);
        }
    }
}