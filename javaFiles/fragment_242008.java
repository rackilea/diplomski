package test;

public class ThreadTest {

    static class MyRunnable implements Runnable {
        int value;

        MyRunnable(int value) {
            this.value = value;
        }

        @Override
        public void run() {
            System.out.println("Started thread " + value);
            System.out.println("Finished thread " + value);
        }
    }

    public static void main(String[] args) {
        Thread[] myThreads;
        int total = 25;
        int size = 5;

        while (total > 0) {
            total -= 5;
            size = 5;
            myThreads = new Thread[size];

            for (int i = 0; i < size; i++) {
                myThreads[i] = new Thread(new MyRunnable(i));
            }
            for (Thread t : myThreads) {
                t.start();
            }
            for (Thread t : myThreads) {
                try {
                    t.join();
                    System.out.println("joined");
                } catch (InterruptedException ex) {
                    System.out.println("error");
                }
            }
            System.out.println("set finished");
        }
    }
}