public enum Xyz {
    Foo, Bar;

    private static final Xyz[] VALUES = values();

    public Xyz fromOrdinal(int ordinal) {
        return VALUES[ordinal];
    }
}