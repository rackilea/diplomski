import static java.lang.Thread.sleep; 

public class Sync2Thread{

 private static Counter c;

 static class Counter{
     private int count;  

     public int getCount() { 
         return count;
     }

     public void incrCount() { 
         count++; 
         System.out.println("+1 => counter= "+count); 
     }
 }

 public static void main (String[] args){
     c = new Counter();

     Thread t = new Thread(new IncrCounter());
     t.start(); 
     Thread t2 = new Thread(new Square());        
     t2.start();
 }

 /**
   * Thread that increment the counter
   */
 static  class IncrCounter extends Thread {

      public void run(){
         for(int i = 0; i < 5; i++)
         {  
            synchronized (c) {

                try {
                    System.out.println("Thread1 - Current Counter = "+c.getCount());
                    System.out.println("Thread1 - Waiting to get notified after squared");
                    // This waits for the other thread perform exponentiation
                    c.wait();
                } catch (InterruptedException ex) {  }
                System.out.println("Thread1 - Waiter thread got notified, let's raise!"); 
                // As soon as the other thread has raised to a power, it increments the counter.
                c.incrCount(); 
                c.notifyAll();
            }  
         }
         System.out.println("Thread1 end___");
     }
 }

  /**
   * Thread that calculates the square
   */
 static class Square extends Thread {

     public void run(){
         for(int i = 0; i < 5; i++)
         {  
            synchronized (c) {

                int x = c.getCount();
                System.out.println("Thread2 - "+ x + " squared =>"+ x*x);    
                try {
                    sleep(500);
                    System.out.println("Thread2 - Sqared done, send notify\n");
                    c.notifyAll();
                    c.wait();
                } catch (InterruptedException ex) {   }
            }
         }
         System.out.println("Thread2 end___");
     } 
 }