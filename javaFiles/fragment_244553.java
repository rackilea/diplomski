class ThreadDemo implements Runnable {
    private String threadName;

    ThreadDemo(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        System.out.println("Thread " + threadName + " exiting.");
    }

}
public class Problem2 {
    public static void main(String[] args) {
        ThreadDemo runnable1 = new ThreadDemo("Thread-1");
        ThreadDemo runnable2 = new ThreadDemo("Thread-2");

        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("ERROR!");
        }
        System.out.println("completed");
    }
}