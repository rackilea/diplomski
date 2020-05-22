public class StuffExample {

    public static void main(String[] args) throws Exception {

        Worker worker = new Worker(new StuffHolder());
        Thread t1 = new Thread(worker); 
        Thread t2 = new Thread(worker); 

        t1.start();
        t2.start();

        Thread.sleep(10000L);
        t1.interrupt();
        t2.interrupt();
    }
}

class Worker implements Runnable {
    private StuffHolder holder;

    public Worker(StuffHolder holder) {
        this.holder = holder;
    }

    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                holder.useStuff();
                Thread.sleep(1000L);
            }
        }
        catch (InterruptedException e) {
        }
    }
}

class StuffHolder {

    private boolean inUse = false;
    private int count = 0;
    public synchronized void useStuff() throws InterruptedException {
        while (inUse) {
            wait();
        }
        inUse = true;
        System.out.println("doing whatever with stuff now, count=" 
            + count + ", thread=" + Thread.currentThread().getName());
        count += 1;
        inUse = false;
        notifyAll();
    }   
}