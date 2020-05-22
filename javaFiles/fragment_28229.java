public class TwoLockRunnable implements Runnable {

    private Lock lockInConstructor;
    private Lock lockInRuntime;

    public TwoLockThread(Lock lockInConstructor, Lock lockInRuntime) {
        this.lockInConstructor = lockInConstructor;
        this.lockInRuntime = lockInRuntime;

        this.lockInConstructor.lock();
    }

    @Override
    public void run() {
        lockInRuntime.lock();

        System.out.println("After the lock in run()");
    }

    public static void main(String[] args) {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        TwoLockRunnable runnable1 = new TwoLockThread(lock1, lock2);
        TwoLockRunnable runnable2 = new TwoLockThread(lock2, lock1);

        new Thread(runnable1).start();
        new Thread(runnable2).start();
    }
}