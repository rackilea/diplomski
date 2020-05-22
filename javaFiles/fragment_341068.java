public class Attribute<T> {
    public T value;

    private Attribute() { }

    public static class StringAttribute extends Attribute<String> {
        public StringAttribute() {
            super();
        }
    }

    public static class IntegerAttribute extends Attribute<Integer> {
        public IntegerAttribute() {
            super();
        }
    }
}