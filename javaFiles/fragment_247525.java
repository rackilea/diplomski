public class HelloWorld implements Runnable {

    private static boolean printHello = true;

    private final String toPrint;
    private final boolean iPrintHello;
    private final Object lock;

    public static void main(String[] args) {
        final Object lock = new Object();
        // first thread prints Hello
        new Thread(new HelloWorld("Hello ", true, lock)).start();
        // second one prints World
        new Thread(new HelloWorld("World ", false, lock)).start();
    }

    public HelloWorld(String toPrint, boolean iPrintHello, Object lock) {
        this.toPrint = toPrint;
        this.iPrintHello = iPrintHello;
        this.lock = lock;
    }

    @Override
    public void run() {
        // don't let it run forever
        for (int i = 0; i < 1000 && !Thread.currentThread().isInterrupted(); ) {
            // they need to synchronize on a common, constant object
            synchronized (lock) {
                // am I printing or waiting?
                if (printHello == iPrintHello) {
                    System.out.print(toPrint);
                    // switch the print-hello to the other value
                    printHello = !printHello;
                    // notify the other class that it can run now
                    lock.notify();
                    i++;
                } else {
                    try {
                        // wait until we get notified that we can print
                        lock.wait();
                    } catch (InterruptedException e) {
                        // if thread is interrupted, _immediately_ re-interrupt it
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            }
        }
    }
}