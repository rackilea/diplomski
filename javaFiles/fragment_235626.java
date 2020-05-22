public class LockTest implements Runnable {
    public void synchronized doNothing() {
        try {
            System.out.println("Starting lock...");
            Thread.sleep(5000);
            System.out.println("Releasing lock...");
        }
        catch (InterruptedException e) {
        }
    }

    public static void main(String[] args) {
        LockTest test1 = new LockTest();
        LockTest test2 = new LockTest();
        new Thread(test1).start();
        new Thread(test2).start();
        // Notice from the output that the threads do not block each other.
    }
}