public class ThreadSynch {

    public static void main(String [] args) throws InterruptedException {

        Object objectLock = new Object();
        Thread synchThread1 = new Thread(new SynchronizedRunnable(objectLock, "foo"));
        Thread synchThread2 = new Thread(new SynchronizedRunnable(objectLock, "bar"));
        synchThread1.start();
        synchThread2.start();

        // wait for the 2 threads to finish before we start the next ones
        synchThread1.join();
        synchThread2.join();

        Thread notSynchThread1 = new Thread(new NotSynchronizedRunnable("hello"));
        Thread notSynchThread2 = new Thread(new NotSynchronizedRunnable("world"));
        notSynchThread1.start();
        notSynchThread2.start();
    }

    private static class SynchronizedRunnable implements Runnable {
        private Object lock;
        private String value;

        public SynchronizedRunnable(Object lock, String value) {
            this.lock = lock;
            this.value = value;
        }

        @Override
        public void run() {
            synchronized (lock) {
                for(int i=0;i<10;i++) {
                    System.out.println(value + " " + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static class NotSynchronizedRunnable implements Runnable {
        private String value;

        public NotSynchronizedRunnable(String value) {
            this.value = value;
        }

        @Override
        public void run() {
            for(int i=0;i<10;i++) {
                System.out.println(value + " " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}