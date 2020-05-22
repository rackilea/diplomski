public class BadThreads {
    public static void main(String[] args) {
        MyThread t1 = new MyThread( 10000);
        MyThread t2 = new MyThread(-10000);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("interrupted");
        }
        System.out.println(MyThread.shared);
    }

    private static class MyThread extends Thread {
        public static int shared;
        private int change;

        public MyThread(int change) {
            this.change = change;
        }

        public void run() {
            while (change < 0) {
                change++;
                shared--;
            }
            while (change > 0) {
                change--;
                shared++;
            }
        }
    }
}