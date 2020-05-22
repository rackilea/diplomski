public class LongRunningTask implements Runnable {

    @Override
    public void run() {

        try {
            // Simulate a long running task
            // Don't do it in a real application
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}