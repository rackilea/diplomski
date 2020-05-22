System.out.println(Thread.currentThread().getName() + " accessing sharedSignal");
//say thread1 acquires lock here
while(sharedSignal.hasDataToProcess()) {
     //thread1 releases lock here, thread2 can acquire lock on the same object
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