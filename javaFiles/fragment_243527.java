//Acquires lock for the entire block
synchronized (sharedSignal) { 
     System.out.println(Thread.currentThread().getName() + " accessing sharedSignal");
     while(sharedSignal.hasDataToProcess()) {
           sharedSignal.setHasDataToProcess(false);
             try {
                System.out.println(Thread.currentThread().getName() + " going to sleep");
                Thread.sleep(3000);
             } catch (InterruptedException e) {
             }
      }        
      sharedSignal.setHasDataToProcess(true);
      System.out.println(Thread.currentThread().getName() + " ended.");
}