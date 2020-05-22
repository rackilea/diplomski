public class MsLunch {
    private long c1 = 0;
    private long c2 = 0;
    private final Object lock = new Object();

    public void inc1() {
        synchronized(lock) {
            c1++;
        }
    }

    public void inc2() {
        synchronized(lock) {
            c2++;
        }
    }
}