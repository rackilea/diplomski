Semaphore acquire(int permits, Semaphore ... semaphores)  throws InterruptedException {
     Semaphore candidate = null;
     while (true) { // polling loop
         for (Semaphore semaphore: semaphores) {
             // attempt to aquire from next Semaphore in the list
             if (semaphore.tryAcquire(permits) {
                 return semaphore;
             }
             // choose the candidate semaphore with maximum available permits
             if (candidate == null || candidate.availablePermits < semaphore.availablePermits) {
                 candidate = semaphore;
             }
         }
         // now we have to wait some time
         // instead of plain sleeping, we wait on the most filled semaphore 
         if (candidate.tryAcquire(permits, 10, TimeUnit.MILLISECONDS) {
             return semaphore;
         }
     }
 }