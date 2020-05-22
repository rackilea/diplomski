/**
 * A source of new {@link UUID} instances.
 */
public interface UuidSource {
    /**
     * Returns a new {@link UuidSource} that generates UUIDs using {@link UUID#randomUUID}.
     */
    public static UuidSource random() {
        return UUID::randomUUID;
    }

    /**
     * Returns a new {@link UUID} instance.
     *
     * <p>The returned value is guaranteed to be unique.
     */
    UUID newUuid();
}