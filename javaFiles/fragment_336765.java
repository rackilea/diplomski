/**
 * A repository of data that can be looked up using a {@link LookupKey}.
 */
public final class Repository {
    private final Map<LookupKey<?>, Object> data = new HashMap<>();

    /**
     * Set a value in the repository.
     *
     * @param <T> The type of data that is being stored.
     * @param key The key that identifies the value.
     * @param value The corresponding value.
     */
    public <T> void put(LookupKey<T> key, T value) {
        data.put(key, value);
    }

    /**
     * Gets a value from this repository.
     *
     * @param <T> The type of the value identified by the key.
     * @param key The key that identifies the desired value.
     */
    public <T> T get(LookupKey<T> key) {
        return key.cast(data.get(key));
    }
}