public enum EXAMPLE_TYPE {
START("start"),
MORE("more");

    // the value which is used for matching
    // the json node value with this enum
    private final String value;

    SectionType(final String type) {
        value = type;
    }

    @Override
    public String toString() {
        return value;
    }
}