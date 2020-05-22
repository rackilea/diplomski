package BinarySemaphore;

public class Semaphore{
    private static Semaphore semaphore;
    private static int resource = 1;

    private Semaphore(){}

    public synchronized void increment(){
        while(isAvailable()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        resource += 1;

        report();

        this.notifyAll();
    }

    public synchronized void decrement(){
        while(!isAvailable()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        resource -= 1;

        report();

        this.notifyAll();
    }

    public synchronized final static boolean isAvailable(){
        return resource == 1 ? true : false;
    }

    public synchronized final static void report(){
        System.out.println("Resource value: " + resource);
    }

    public final static Semaphore getInstance(){
        if(semaphore == null){
            semaphore = new Semaphore();
        }
        return semaphore;
    }
}