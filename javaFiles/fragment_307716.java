public class ExecutorServiceTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        ThreadB threadB = new ThreadB();
        ThreadA threadA = new ThreadA(threadB);

        executor.execute(threadA);
        executor.execute(threadB);

        executor.shutdown();
        while (!executor.isTerminated());
        System.out.println("Finished all threads");

    }

    static class ThreadA extends Thread {

        private final ThreadB waitThread;

        public ThreadA(ThreadB waitThread) {
            this.waitThread = waitThread;
        }

        @Override
        public void run() {
            synchronized (waitThread) {
                try {
                    waitThread.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("B Count Total : " + waitThread.getCount());

                for (int i = waitThread.getCount(); i < 200; i++) {
                    System.out.println("A Counting " + i);
                }
            }
        }
    }

    static class ThreadB extends Thread {

        private int count = 0;

        @Override
        public void run() {
            synchronized (this) {
                while (count < 100) {
                    System.out.println("B Counting " + count);
                    count++;
                }
                notify();
            }
        }

        public int getCount() {
            return count;
        }

    }

}