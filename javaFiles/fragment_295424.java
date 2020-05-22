public enum Checker {

    EMPTY ("Empty"),
    RED ("Red"),
    YELLOW ("Yellow");

    private final String value;

    private Checker(final String value) {
        this.value = value;
    }

    public String getValue() { return value; }
}