public class TestedClass {
    private UuidSource uuidSource = UuidSource.random();

    public UUID getUUID() {
        return uuidSource.newUuid();
    }
    // etc.
}