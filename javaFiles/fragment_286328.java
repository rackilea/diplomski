public class Things implements Runnable {
    private volatile boolean running;  // this indicates it's running

    public Things() {
        running = true;  // thread is running when it's created (though not really until "run" is called)
    }

    // called from start()
    public void run() {
        while (running) {
            System.out.println("Hello");
        }
    }

    // call this method to stop the thread, from outside on the object reference
    public synchronized void stop() {
        running = false;
    }
}