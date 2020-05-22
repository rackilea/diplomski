import java.util.concurrent.Semaphore;

public class Example {

  public static void main(String[] args) throws InterruptedException {
    MyRunnable target = new MyRunnable();
    Thread thread2    = new Thread(target);

    thread2.start();
    target.waitUntilFinish();

    System.out.println("MyRunnable ends first!");
  }


  public static class MyRunnable implements Runnable {

    private Semaphore workDone = new Semaphore(0);
    private int count;

    @Override
    public void run() {
        while (true) {
            // heavy work here...
            if (this.count < 5) {
                System.out.println("Iteration: " + (++this.count));
            } else {
                this.workDone.release();
                break;
            }
            try { Thread.sleep(2000L); } catch (InterruptedException ex) { }
        }
    }

    public void waitUntilFinish() throws InterruptedException {
        this.workDone.acquire();
    }
  }
}