class LongTask implements Callable<Double> {
    public Double call() {

         // Sleep for a while; handle InterruptedException appropriately
         try {
             Thread.sleep(10000);
         } catch (InterruptedException ex) {
             System.out.println("Exiting gracefully!");
             return null;
         }


         // Compute for a while; check Thread.isInterrupted() periodically
         double sum = 0.0;
         for (long i = 0; i < 10000000; i++) {
             sum += 10.0
             if (Thread.currentThread().isInterrupted()) {
                 System.out.println("Exiting gracefully");
                 return null;
             }
         }

         return sum;
    } 
}