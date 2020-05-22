import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SO35570728 {

    private class Task implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " started");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " finished");
        }
    }

    public static void main(String[] args) {
        LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(200, 200, 50000L, TimeUnit.MILLISECONDS, queue);

        for(int i= 0 ; i < 100000 ; i++){
            System.out.println("Active threads: " + threadPoolExecutor.getActiveCount() + ".  The queue has " + queue.size() + " threads.");
            threadPoolExecutor.submit(new SO35570728().new Task());
        }
    }
}