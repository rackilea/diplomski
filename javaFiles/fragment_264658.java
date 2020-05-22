public class Exit {

public static void main(String[] args) {

    Runtime.getRuntime().addShutdownHook(new ExitHok());

    Thread t = new Thread(new Printer());
    t.start();

}

private static class ExitHok extends Thread {
    @Override
    public void run() {
        System.out.println("Received shutdown");
        Runtime.getRuntime().halt(0);
    }
}

private static class Printer implements Runnable {
    @Override
    public void run() {
        int counter = 0;
        while (true) {
            System.out.println(++counter);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}