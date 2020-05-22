public class Worker implements Runnable {
   Consumer consumer;

   public Worker(Consumer consumer) {
       this.consumer = consumer;
   }

   @Override public void run() {
       // Do work
       value = // get value
       consumer.put(value);
   }
}