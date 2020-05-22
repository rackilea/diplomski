/**
 * A key that knows its own name and type.
 */
public final class LookupKey<T> {
    // These are the "enumerated" keys:
    public static final LookupKey<String> FOO = new LookupKey<>("FOO", String.class);
    public static final LookupKey<Integer> BAR = new LookupKey<>("BAR", Integer.class);

    private final String name;
    private final Class<T> type;

    public LookupKey(String name, Class<T> type) {
        this.name = name;
        this.type = type;
    }

    /**
     * Returns the name of this key.
     */
    public String name() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * Cast an arbitrary object to the type of this key.
     * 
     * @param object an arbitrary object, retrieved from a Map for example.
     * @throws ClassCastException if the argument is the wrong type.
     */
    public T cast(Object object) {
        return type.cast(object);
    }

    // not shown: equals() and hashCode() implementations
}