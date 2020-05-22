public class Notifier extends Thread{
   private BlockingQueue<E> consumerQueue = null;
   public setConsumerQueue(BlockingQueue<E> val){
      consumerQueue = val;
   }
   // main method where data is received from socket...
   public void run(){
      while(!interrupted()){
           data = ... // got new data here
           if(!data.isChanged()) continue;
           // Post new data only when it has changed
           if(consumerQueue!=null) consumerQueue.offer(data);
      }
   }
}

public class Consumer extends Thread{
   private BlockingQueue<E> consumerQueue = new BlockingQueue<E>();
   public Consumer (Producer val){
      val.setConsumerQueue(consumerQueue);
   }
   public void run(){
      while(!interrupted()){
           data = consumerQueue.take();// block until there is data from producer
           if(data !=null) processData(data);
      }
   }
}