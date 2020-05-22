public class NaturalNoPrint {
    public static void main(String[] args) {
        Semaphore oddMutex = new Semaphore(0);
        Semaphore evenMutex = new Semaphore(0);
        Thread oddThread = new Thread(new OddThread(oddMutex,evenMutex));
        Thread evenThread = new Thread(new EvenThread(oddMutex,evenMutex));
        evenThread.start();
        oddThread.start();
    }
}

class OddThread implements Runnable{
    private int no=1;
    private Semaphore oddMutex,evenMutex;
    OddThread(Semaphore oddMutex,Semaphore evenMutex){
        this.oddMutex=oddMutex;
        this.evenMutex=evenMutex;
    }

    public void run(){
        while(true){
            //synchronized(lock){
                try {           
                    //lock.wait();
                    oddMutex.acquire();
                    System.out.println(no);
                    no+=2;
                    Thread.sleep(1000); 
                    //lock.notify();
                    evenMutex.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            //}
        }
    }
}


class EvenThread implements Runnable{
    private int no=2;
    //private Object lock;
    private Semaphore oddMutex,evenMutex;

    EvenThread(Semaphore oddMutex,Semaphore evenMutex){
        this.oddMutex=oddMutex;
        this.evenMutex=evenMutex;
    }
    public void run(){
        while(true){
            //synchronized(lock){
                try{            
                    //lock.notify();
                    //lock.wait();
                    oddMutex.release();
                    evenMutex.acquire();
                    System.out.println(no);
                    no+=2;
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            //}
        }
    }
}