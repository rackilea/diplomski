public class CounterThread extends Thread {
    private final Semaphore mySemaphore;
    private final Semaphore nextSemaphore;
    public CounterThread(String name, Semaphore mySemaphore, Semaphore nextSemaphore) {
        super(name);
        this.mySemaphore = mySemaphore;
        this.nextSemaphore = nextSemaphore;
    }
    @Override
    public void run() {
        try {
            for (int i = 0; i <= 10; i++) {
                this.mySemaphore.acquire();
                System.out.println(getName() + ":" + i);
                this.nextSemaphore.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace(System.out);
        }
    }
}