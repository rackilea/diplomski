import java.util.ArrayList;
import java.util.List;

public class ThreadRestarterMain {
    public static void main(String... ignored) throws InterruptedException {
        long start = System.currentTimeMillis();
        // time how long it takes to start a few threads and stop them again.
        int threads = 2000;
        List<Thread> threadList = new ArrayList<>();
        while (threadList.size() < threads) {
            Thread e = new Thread(new Runnable() {
                @Override
                public void run() {
                    Thread.yield();
                }
            });
            e.start();
            threadList.add(e);
        }
        for (Thread thread : threadList) {
            thread.join();
        }
        long time = System.currentTimeMillis() - start;
        System.out.printf("Took %.3f ms on average to start/stop a thread%n", (double) time / threads);
    }
}