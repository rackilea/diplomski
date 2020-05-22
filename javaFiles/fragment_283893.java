public class GenreWrapper {
    private Genre genre;

    public GenreWrapper(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return this.genre.getName();
    }

    public Genre getGenre() {
        return this.genre;
    }
}