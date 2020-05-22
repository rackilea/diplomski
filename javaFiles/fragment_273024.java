public class MovieItem {
    private double popularity;
    private String photo;
    private String name;

    public MovieItem(double popularity, String poster_path, String original_title) {
        this.popularity = popularity;
        this.photo = poster_path;
        this.name = original_title;
    }

    public double getPopularity() { return popularity; }
    public String getPhoto() { return photo; }
    public String getName() { return name; }

    public Uri getFullPosterPath() {
        return Uri.parse("http://image.tmdb.org/t/p/")
                .buildUpon()
                .appendPath("w185")
                .appendEncodedPath(getPhoto())
                .build();
    }
}