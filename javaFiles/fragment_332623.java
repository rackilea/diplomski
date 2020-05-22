public class racer1 implements Runnable {
    public void run() {
        for(int x = 0; x < 100; x++) {
            System.out.println(x);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}