public class Movie {
    private String name;
    private String genre;

    ...

    @Override
    public String toString() {
        return genre;
        // alternatively, you can concatenate data into a String and return that, e.g. return name + " (" + genre + ")"
    }
}