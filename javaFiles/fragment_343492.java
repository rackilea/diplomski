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
                work();
            }
        } catch (final InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    synchronized protected void work() throws InterruptedException {
        while(suspended) {
            System.out.println("suspended");
            wait();
            System.out.println("resumed");
        }
    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }

    synchronized void suspend() {
        suspended = true;
        notifyAll();
    }

    synchronized void resume() {
        suspended = false;
        notifyAll();
    }

    public static void main(final String[] args) throws InterruptedException  {
        final SuspendDemo R1 = new SuspendDemo( "Thread-1");
        R1.start();
        R1.suspend();
        Thread.sleep(500);
        R1.resume();
    }
}