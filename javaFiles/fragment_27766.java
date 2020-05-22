public class InterruptTest {

    static class TThread extends Thread {
        public void run() {
            while(!isInterrupted()) {
                System.out.println("Do Work!!!");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new TThread();
        t.start();

        Thread.sleep(4000);
        System.out.println("Sending interrupt!!");
        t.interrupt();
        Thread.sleep(4000);
    }

}