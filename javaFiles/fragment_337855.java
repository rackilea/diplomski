public class AtomicInteger extends Number implements java.io.Serializable {
    public String toString() {
        return Integer.toString(get());
    }
    public final int incrementAndGet() {
        return unsafe.getAndAddInt(this, valueOffset, 1) + 1;
    }
}