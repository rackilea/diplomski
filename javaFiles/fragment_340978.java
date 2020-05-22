public enum EnumTest {

    ONE, TWO() {
        @Override public String hello() {
            return "World";
        }
    };

    public String hello() {
        return "Hello";
    }
}