public class MyObject {
    private final Supplier<LocalDateTime> supplier;
    private LocalDateTime date;

    public MyObject() {
        this(LocalDateTime::now);
    }

    public MyObject(final Supplier<LocalDateTime> supplier) {
        this.supplier = supplier;
    }

    public LocalDateTime getDate() { return this.date; }

    public void myMethod() {
        this.date = supplier.get();
    }
}