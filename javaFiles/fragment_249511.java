import java.util.concurrent.*;

public class Test implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        Test task = new Test();
        int threads = Runtime.getRuntime().availableProcessors();
        ExecutorService pool = Executors.newFixedThreadPool(threads);
        for (int i = 0; i < threads; i++) {
            pool.submit(task);
        }
        pool.awaitTermination(120, TimeUnit.SECONDS);
    }

    @Override public void run() {
        System.out.println("Task running...");
        int i = 0;
        while (true) {
            i++;
        }
    }
}