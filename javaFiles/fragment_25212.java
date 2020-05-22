public static class Movie implements Comparable<Movie> {
    private static final Comparator<Movie> COMPARATOR =
        Comparator.comparing(Movie::getName).thenComparing(Movie::getAuthor);

    ...

    @Override
    public int compareTo(Movie other) {
        return COMPARATOR.compare(this, other);
    }
}