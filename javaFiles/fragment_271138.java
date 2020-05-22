public class SomeClient {
   public void start() {
       Queue sharedQueue = new LinkedList();

       producer = new Producer( sharedQueue );
       consumer = new Consumer( sharedQueue );

       producer.start();
       consumer.start();
   }
}