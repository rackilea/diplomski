public interface ByString<T> { // Choose a better name.
    T find(String toString);
}
[...]
    private static final ByString<Blah> blahs = byString(Blah.values());
[...]
    public static <T> ByString<T> byString(T[] values) {
        final T[] valuesCopy = values.clone();
        return new ByString<T>() {
            public T find(String toString) {
                return SomeClass.findByString(valuesCopy, toString);
            }
        };
    }
[...]