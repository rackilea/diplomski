public class ThreadA {
    public static Object latch = new Object();
    public static boolean done = false;
    public static void main(String[] args) {
        ThreadB b = new ThreadB();
        b.start();
        synchronized(latch ) {
            while (!done) {   //wait for B to indicate it is finished.
                latch.wait(); 
            }
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
           ThreadA.done = true;         
           ThreadA.latch.notify();
       }
    }
}