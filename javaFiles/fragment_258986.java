public class SubClass1 implements Runnable {
    private AtomicBoolean b;
    public SubClass1(AtomicBoolean b) {
        this.b = b;
    }

    public void run() {
        while(b.get()) {  // Assuming SubClass2 sets it to false when it's no longer running
            // Do something
        }
    }
}