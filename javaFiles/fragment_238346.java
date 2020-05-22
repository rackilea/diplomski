public class Test {
    private static int count = 0;
    private static final Object countLock = new Object();

    public void incrementCount() {
        synchronized (countLock) {
            count++;
        }
    }
}