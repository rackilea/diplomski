public class LockTest implements Runnable {
    private Object thingToLockWith;

    public LockTest(Object thingToLockWith) {
        this.thingToLockWith = thingToLockWith;
    }

    public void doNothing() {
        synchronized (thingToLockWith) {
            try {
                System.out.println("Starting lock...");
                Thread.sleep(5000);
                System.out.println("Releasing lock...");
            }
            catch (InterruptedException e) {
            }
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();

        LockTest test1 = new LockTest(lock);
        LockTest test2 = new LockTest(lock);
        new Thread(test1).start();
        new Thread(test2).start();
        // Notice from the output they block.
    }