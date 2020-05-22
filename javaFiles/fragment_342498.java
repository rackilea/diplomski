public class MovieParcelable implements Parcelable {

    public static final Creator<MovieParcelable> CREATOR = new Creator<MovieParcelable>() {
        @Override
        public MovieParcelable createFromParcel(Parcel in) {
            int id = in.readInt();
            String poster = in.readString();
            // ...
            double rating = in.readDouble();
            String releaseDate = in.readString();
            return new MovieParcelable(id, poster, ..., rating, releaseDate);
        }

        @Override
        public MovieParcelable[] newArray(int size) {
            return new MovieParcelable[size];
        }
    };

    private final Movie movie;

    public MovieParcelable(Movie movie) {
        this.movie = movie;
    }

    MovieParcelable(int id, String poster, ..., double rating, String releaseDate) {
        this(new Movie(id, poster, ..., rating, releaseDate));
    }

    public Movie getMovie() { return movie; }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(movie.getId());
        dest.writeString(movie.getPoster());
        // ...
        dest.writeDouble(movie.getRating());
        dest.writeString(movie.getReleaseDate());
    }
}