public enum Rating {
    G("G"), // the string arguments should exactly match what's in the database.
    PG("PG"),
    PG13("PG-13"),
    R("R"),
    NC17("NC-17");

    private static final Map<String, Rating> LOOKUP = Arrays.stream(values())
            .collect(Collectors.toMap(Rating::getRating, Function.identity()));

    private final String rating;

    Rating(final String rating) {
        this.rating = rating;
    }

    public String getRating() {
        return rating;
    }

    public Rating fromString(final String rating) {
        // You may want to include handling for the case where the given string
        // doesn't map to anything - implementation is up to you.
        return LOOKUP.get(rating);
    }
}