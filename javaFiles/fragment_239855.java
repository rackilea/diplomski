public class Cls {
    // The last id I used.
    private static final AtomicInteger nextId = new AtomicInteger();
    // My id
    private final int id = nextId.getAndIncrement();

    public Cls() {
    }
}