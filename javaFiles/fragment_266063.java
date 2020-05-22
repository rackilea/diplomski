class MyRunnable implements Runnable {

   private Process pr; 

   public void run() {

      // ...

      pr = pb.start();
   }

   public shutdown() {
      pr.destroy();
      interrupt();
   }
}