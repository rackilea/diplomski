public class ConsumerThread implements Runnable{
    private int status = 0;
    private Random rand = new Random();
    private final CountDownLatch startSignal;

    public ConsumerThread(CountDownLatch latch){
        this.startSignal = latch;
    }

    public int getStatus() {
        return status;
    }

    private void setStatus(int status) {
        this.status = status;
    }

    public void run() {
        try {
            this.startSignal.await();
            while (true){
                this.setStatus(rand.nextInt(10));
            }
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }       
    }
}