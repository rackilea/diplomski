public static void main (String args[])
{
    AccessGate gate = new AccessGate();

    // create as many threads as you like
    Thread t1 = new MyThread(gate);
    Thread t2 = new MyThread(gate);

    // start all the threads you created
    t1.start();
    t2.start();        
}

class MyThread extends Thread {

    AccessGate gate;

    public MyThread(AccessGate g) {
        gate = g;
    }

    public void run() {
        gate.claimAccess();
        // Do something or print something.
        // Could output several statements.
        // Why not do a sleep as well to see if other threads interrupt
        // this code section.
        gate.releaseAccess();
    }
}