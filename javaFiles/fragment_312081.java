public class TestedClass {
    private final Supplier<UUID> uuidSupplier = UUID::randomUUID;

    public String getUuid() {
        return uuidSupplier.get().toString();
    }
}