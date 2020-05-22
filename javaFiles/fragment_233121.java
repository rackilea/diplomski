import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Schedular {
    private static int numOfTasks = 10 ;

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
        HealtchChecker hChecker = new HealthChecker();
        for(int i=0;i<numOfTasks;i++){
            service.execute(new Workers(hChecker));
        }
    }
}

class Workers implements Runnable{

    private HealtchChecker hChecker;

    public Workers(HealtchChecker hChecker){
        this.hChecker = hChecker;
    }

    @Override
    public void run() {
        /*
         * This can throw different exceptions , eg:    
         */
         while(true) {
            try{

            }catch (InterruptedException ie) {
                throw ie;   
            }catch(Exception e){
                e.printStackTrace();
                HealthChecker.checkHealth();
            }
         }
    }
}

class HealthChecker implements Runnable {

    private final Semaphore semaphore = new Semaphore(1, true);

    public void checkHealth() {
        try {
            semaphore.acquire();
        } finally {
            semaphore.release();
        }
    }

    @Override
    public void run(){
        //code to check for errors that cause threads to pause.
        if (inErrorState) {
            semaphore.acquire();
        } else {
            semaphore.release();
        }
    }

}