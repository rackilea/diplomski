public class MessageManipulatorThread implements Runnable {

    private BlockingQueue<String> sharedQueue;
    private ExecutorService executor;

    public MessageManipulatorThread(BlockingQueue<String> sharedQueue, ExecutorService executor){
        this.sharedQueue = sharedQueue;
        this.executor = executor;
    }

    public void run() {
        while (true) {
            try {
                String msg = sharedQueue.take();
                System.out.println(Thread.currentThread().getName() + "manipulator runnning => "+msg);
                executor.execute(new PublisherThread(msg));
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}