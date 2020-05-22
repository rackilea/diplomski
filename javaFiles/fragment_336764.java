/**
 * A key that knows its own name and type.
 */
public final class LookupKey<T> {
    // This is the registry of all known keys.
    // (It needs to be declared first because the create() function needs it.)
    private static final Map<String, LookupKey<?>> knownKeys = new HashMap<>();

    // These are the "enumerated" keys:
    public static final LookupKey<String> FOO = create("FOO", String.class);
    public static final LookupKey<Integer> BAR = create("BAR", Integer.class);


    /**
     * Create and register a new key. If a key with the same name and type
     * already exists, it is returned instead (Flywheel Pattern).
     *
     * @param name A name to uniquely identify this key.
     * @param type The type of data associated with this key.
     * @throws IllegalStateException if a key with the same name but a different
     *     type was already registered.
     */
    public static <T> LookupKey<T> create(String name, Class<T> type) {
        synchronized (knownKeys) {
            LookupKey<?> existing = knownKeys.get(name);
            if (existing != null) {
                if (existing.type != type) {
                    throw new IllegalStateException(
                            "Incompatible definition of " + name);
                }
                @SuppressWarnings("unchecked")  // our invariant ensures this is safe
                LookupKey<T> uncheckedCast = (LookupKey<T>) existing;
                return uncheckedCast;
            }
            LookupKey<T> key = new LookupKey<>(name, type);
            knownKeys.put(name, key);
            return key;
        }
    }

    /**
     * Returns a list of all the currently known lookup keys.
     */
    public static List<LookupKey<?>> values() {
        synchronized (knownKeys) {
            return Collections.unmodifiableList(
                    new ArrayList<>(knownKeys.values()));
        }
    }

    private final String name;
    private final Class<T> type;

    // Private constructor. Only the create method should call this.
    private LookupKey(String name, Class<T> type) {
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
}