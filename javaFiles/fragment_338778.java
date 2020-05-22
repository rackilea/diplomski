import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Semaphore;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        final Semaphore mutexRefresh = new Semaphore(0);
        final Semaphore mutexRefreshing = new Semaphore(1);
        int refresh = 0;

        Timer timRefresh = new Timer();
        timRefresh.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(mutexRefreshing.tryAcquire()) {
                    mutexRefreshing.release();
                    mutexRefresh.release();
                }
            }
        }, 0, 1000/50);

        // The timer is started and configured for 50fps
        Date startDate = new Date();
        while(true) { // Refreshing loop
            mutexRefresh.acquire();
            mutexRefreshing.acquire();

            // Refresh 
            refresh += 1;

            if(refresh % 50 == 0) {
                Date endDate = new Date();
                System.out.println(String.valueOf(50.0*1000/(endDate.getTime() - startDate.getTime())) + " fps.");
                startDate = new Date();
            }

            mutexRefreshing.release();
        }
    }
}