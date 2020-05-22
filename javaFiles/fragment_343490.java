public class SuspendDemo implements Runnable {
    public Thread t;
    private final String threadName;
    boolean suspended = false;
    SuspendDemo(final String name){
        threadName = name;
        System.out.println("Creating " +  threadName );
    }

    @Override
    public void run() {
        System.out.println("Running " +  threadName );
        try {
            while (true) {
                System.out.println("Thread: " + threadName);
                // Let the thread sleep for a while.
                Thread.sleep(300);
                while(suspended) {
                    System.out.println("suspended");
                    Thread.sleep(50);
                }
            }
        } catch (final InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }

    void suspend() {
        suspended = true;
    }

    void resume() {
        suspended = false;
        notify();
    }

    public static void main(final String[] args) throws InterruptedException  {
        final SuspendDemo R1 = new SuspendDemo( "Thread-1");
        R1.start();
        R1.suspend();
        Thread.sleep(500);
        R1.resume();
    }
}