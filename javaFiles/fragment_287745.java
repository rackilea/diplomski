synchronized (workQueue) {
     // you must do a while here
     while (workQueue.isEmpty()) {
         workQueue.wait();
     }
     workQueue.remove();
 }