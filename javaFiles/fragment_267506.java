class LongRunningWorker(BlockingQueue<String> workQueue) extends Runnable {
    final BlockingQueue<String> workQueue;
    LongRunningWorker(BlockingQueue<String> workQueue) {
        this.workQueue = workQueue;
    }   

    public void run() {
       while((String work =  workQueue.poll(3, TimeUnit.Second) != null) {
           try {
               new Worker(work).run();
           } catch (Exception e) {
               // 
           }
        }
    }
}