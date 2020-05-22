class Movie {
    private long id;
    private String title;
    private LocalDate release;
    private String contentDescription;

    Movie(long id, String title) {
        this.id = id;
        this.title = title;
    }
    ...
}

class MovieCopy {
    private long copyId;
    private Movie movie;
    private LocalDate lastHired;
    private LocalDate latestReturn;

    MovieCopy(long id, Movie movie) {
        this.copyId = id;
        this.move = movie;
    }
    ...
}