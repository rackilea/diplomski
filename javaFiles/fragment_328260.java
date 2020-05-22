import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TimerTaskQuestion {

    public static void main(String[] args) {
        OrderProcessScheduler orderScheduler = new OrderProcessScheduler();
        Timer timer = new Timer();
        timer.schedule(orderScheduler, 500, 1000);
    }

    public static class OrderProcessScheduler extends TimerTask {

        private ExecutorService ex;

        public OrderProcessScheduler() {
            this.ex = Executors.newFixedThreadPool(10);
            try {
                this.ex.awaitTermination(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void run() {
            System.out.println("Number of active thread : " + ((ThreadPoolExecutor)this.ex).getActiveCount());
            this.ex.execute(new orderThreadImpl());
        }

        public void initiateShutdown(){
            this.ex.shutdown();
        }
    }

    public static class orderThreadImpl implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println("Executed from : " + Thread.currentThread().getName());
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}