public class BallPanel extends JPanel {
    protected static final Object SUSPEND_LOCK = new Object();

    /*...*/

    Thread t;
    t = new Thread(){
        @Override
        public void run(){
            /*...*/
            synchronized(SUSPEND_LOCK ){
                if (threadSuspended==true) {SUSPEND_LOCK.wait();}
            }
        }
    };

    /*...*/

    public void resume() {
        synchronized(SUSPEND_LOCK){
            threadSuspended = false;
            SUSPEND_LOCK.notify();
        }
    }