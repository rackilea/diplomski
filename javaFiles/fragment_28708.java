public enum EnumQ {

    Enum1("A", 1, Constants.STRINGS),
    Enum2("B", 1, Constants.STRINGS),
    Enum3("C", 1, Constants.STRINGS);

    private final String foo;
    private final int bar;
    private final List<String> list;

    EnumQ(String foo, int bar, List<String> list) {
        this.foo = foo;
        this.bar = bar;
        this.list = list;
    }

    private static class Constants {
        private static final List<String> STRINGS = unmodifiableList(asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"));
    }
}