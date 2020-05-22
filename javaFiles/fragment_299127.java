package stackOv;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BackPressure {
    public static void main(String[] args) {
        // this is the backing work queue; in this case, it is of bounded size
        ArrayBlockingQueue<Runnable> q = new ArrayBlockingQueue<>(1);
        ExecutorService ex = new ThreadPoolExecutor(3, 3, 30, TimeUnit.SECONDS, q,
                new ThreadPoolExecutor.CallerRunsPolicy());
        for(int i=0; i< 100; i++) {
            ex.execute(new TestWork(i));
        }
        System.out.println("finished!");
    }

    private static class TestWork implements Runnable {
        private int i;
        public TestWork(int i) {
            this.i = i;
        }
        @Override
        public void run() {
            System.out.println("hi: " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}