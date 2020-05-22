public class Slaves implements Runnable {

   // ...

   @Override
   public void run() {

      while(condition) {

         // computation
         // ...

         try {
            // do not proceed, until all [count] threads
            // have reached this position
            barrier.await();
         } catch (InterruptedException ex) {
            return;
         } catch (BrokenBarrierException ex) {
            return;
         }
      }
   }
}