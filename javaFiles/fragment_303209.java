class ThreadA extends Thread {
    private int sum = 0;

    @Override
    public void run() {
            System.out.println();
            for (int i = 0; i < 100; i++) {
                sum += i;
            }
    }
    public int getSum() {
        return sum;
    }
}

public class WaitNNotify {
    public static void main(String[] args) {
        ThreadA t = new ThreadA();
        t.start();
        System.out.println("Waiting for ThreadA to complete..."+ Thread.currentThread().getName());
        try {
            t.join();
            System.out.println("Finally the Thread is completed ... "+ t.getSum());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}