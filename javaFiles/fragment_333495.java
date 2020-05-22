public class Demo {

    public class Worker implements Runnable {
        @Override
        public void run() {
            Runnable task = getTaskFromQueue();
            while (task != null) {
                task.run();
                task = getTaskFromQueue();  // This might get blocked if the queue is empty, so the worker thread will not terminate
            }
        }
    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        Thread thread = new Thread(worker);
        thread.start();
    }

}