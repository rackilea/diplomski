import java.util.LinkedList;
import java.util.Queue;

class Producer extends PubSub implements Runnable{

    @Override
    public void run() {
         int index = 0;

         while (true) {
            synchronized(queue){
                while (queue.size() == QUEUE_SIZE){
                    try {
                        System.out.println("Producer waits");
                        queue.notify();
                        queue.wait();
                    } catch (InterruptedException e) {
                       e.printStackTrace();
                    }
                }

                System.out.println("Produce element " + (++index));
                queue.add(2);
                queue.notify();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }


            }
        }
    }
}


class Consumer extends PubSub implements Runnable{

     @Override
     public void run() {
         while (true) {
             synchronized(queue) {

                while (queue.isEmpty()){
                    try {
                         System.out.println("Consumer waits");
                         queue.notify();
                         queue.wait();
                    } catch (InterruptedException e) {
                         e.printStackTrace();
                    }
                }

                System.out.println("Consume element " + queue.poll());
                queue.notify();

            }
         }

     }

  }

public class PubSub {
     static Integer QUEUE_SIZE = 100;

     static Queue<Integer> queue = new LinkedList<Integer>();

     public static void main(String[] args) {
          Producer producer = new Producer();
          Consumer consumer = new Consumer();

          Thread producerThread = new Thread(producer);
          Thread consumerThread = new Thread(consumer);

          producerThread.start();
          consumerThread.start();

          System.out.println("Started both the threads");
     }

 }