public enum CountryAndOneContinent {

    INDIA("India"),
    RUSSIA("Russia"),
    NORTH_AMERICA("North America");

    private String displayName;

    CountryAndOneContinent(String displayName) {
        this.displayName = displayName;
    }

    public String displayName() { return displayName; }

    // Optionally and/or additionally, toString.
    @Override public String toString() { return displayName; }
}