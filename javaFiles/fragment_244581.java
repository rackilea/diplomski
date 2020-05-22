public class Aufzahlen {
    private final AtomicInteger atomicInt = new AtomicInteger(1); // set initial value with constructor argument

    public void aufzahlen() {
        atomicInt.incrementAndGet();
    } // no need for synchronization because updates are atomic and are automatically visible
}