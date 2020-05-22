private boolean addWorker(Runnable firstTask, boolean core) {
     // After some checks, it creates Worker and start the thread
    Worker w = new Worker(firstTask);
    Thread t = w.thread;

   // After some checks, thread has been started
   t.start();
}