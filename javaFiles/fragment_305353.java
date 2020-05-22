import java.util.*;
import java.util.concurrent.*;

class Setup {
   public static void main(String[] args) {
     BlockingQueue<Character> q = new LinkedBlockingQueue<>();
     Producer p = new Producer(q);
     Consumer c = new Consumer(q);
     new Thread(p).start();
     new Thread(c).start();
   }
}

class Producer implements Runnable {
   private final BlockingQueue<Character> queue;
   private final Scanner scanner = new Scanner(System.in);
   Producer(BlockingQueue<Character> q) { queue = q; }
   public void run() {
     try {
       while (true) { 
         queue.put(produce()); 
       }
     } catch (InterruptedException ex) {
       Thread.currentThread().interrupt();  // set interrupt flag
     } finally {
       scanner.close();
     }
   }
   Character produce() {
      return scanner.nextLine().charAt(0);
   }
}

class Consumer implements Runnable {
   private final BlockingQueue<Character> queue;
   Consumer(BlockingQueue<Character> q) { queue = q; }
   public void run() {
     try {
       while (true) { 
         consume(queue.take()); 
       }
     } catch (InterruptedException ex) {}
   }
   void consume(Character c) { 
     System.out.println("Received character: " + c);
   }
}