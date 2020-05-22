class Demo {
   final CyclicBarrier barrier;

   class Broswer implements Runnable {
     Worker() { }
     public void run() {
       while (!done()) {
         try {
           // wait for other threads
           barrier.await();
           // work for something, in your case an hour, but how can you control that
           // work....
           // sleep for a certain time
           sleep(certain time)
         } catch (InterruptedException ex) {
           return;
         } catch (BrokenBarrierException ex) {
           return;
         }
       }
     }
   }

   public static main(String args[]) {
     barrier = new CyclicBarrier(N);
     for (int i = 0; i < N; ++i)
       new Thread(new Broswer()).start();

     // wait until all done, in your case, forever.
   }
 }