public class Referee implements Runnable {

    @Override
    public void run() {
        try {
            while (!a.finish) {
                synchronized (a.class) {
                    System.out.println("Check for winner.");
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException interruptedException) {
        }
    }
}