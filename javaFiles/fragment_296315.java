public class A {
    private final Object lock = new Object();
    private int value;
    private A next;

    public void process() {
        synchronized (lock) {
            synchronized (next.lock) {
                // etc
            }
        }
    }
}