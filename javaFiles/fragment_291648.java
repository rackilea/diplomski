import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class ExecutorTest {

    public static void main(String[] args) {

        ExecutorService executorService = new ThreadPoolExecutor(0, 64, 1000,
                        TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>());

        for (int i = 0; i <= 500; i ++) {

            try {
                Thread.sleep(new Random().nextInt(200));
            } catch (InterruptedException e) {
            }

            executorService.submit(new TestTask());
        }
    }

    public static class TestTask implements Runnable {
        public void run() {
            try {
                Thread.sleep(new Random().nextInt(1500));
            } catch (InterruptedException e) {
            }
        }
    }
}