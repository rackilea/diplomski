enum FilmEntry {
    COLUMN_FILM_ID("Film Id"),
    COLUMN_TITLE("Title"),
    COLUMN_POSTER_URL("Poster URL"),
    COLUMN_OVERVIEW("Overview"),
    COLUMN_RATING("Rating"),
    COLUMN_DATE("Date"),
    COLUMN_POPULARITY("Popularity"),
    COLUMN_VIDEOS("Videos"),
    COLUMN_REVIEWS("Reviews");

    private String title;

    FilmEntry(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}

System.out.println FilmEntry.COLUMN_FILM_ID.toString(); // returns "Film Id"
System.out.println FilmEntry.COLUMN_FILM_ID.name(); // returns "COLUMN_FILM_ID"
System.out.println FilmEntry.COLUMN_FILM_ID.ordinal(); // returns 0