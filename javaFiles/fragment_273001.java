public class Decode implements Runnable {
   private boolean cancel = false;
   private ConcurrentLinkedQueue<Data> queue = new ConcurrentLinkedQueue<>();
   private FetchOperands nextComponent;

   public void run() {
       while(!cancel) {
           Data data = queue.poll();
           if(data != null) {
               ...
               nextComponent.enqueue(data);
           } else (Thread.sleep(500);
       }
   }

   public void enqueue(Data data) {
       queue.offer(data);
   }

   public void cancel() {
       cancel = true;
   }

   public void setFetchOperands(FetchOperands nextComponent) {
       this.nextComponent = nextComponent;
   }
}

public class Main implements Runnable {
    public void run() {
        Decode decode = new Decode();
        FetchOperands fetchOperands = new FetchOperands();
        decode.setFetchOperands(fetchOperands);
        Thread t1 = new Thread(decode);
        Thread t2 = new Thread(fetchOperands);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}