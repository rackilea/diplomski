public class ThreadA {
    public static Object latch = new Object();
    public static void main(String[] args) {
        ThreadB b = new ThreadB();
        b.start();
        synchronized(latch ) {
            latch.wait(); //wait for B to finish a calculation
        }
        System.out.println("Total is: " + b.total);

    }
}

class ThreadB extends Thread {
    int total;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            total += i;
        }
       synchronized(ThreadA.latch) {
           ThreadA.latch.notify();
       }
    }
}