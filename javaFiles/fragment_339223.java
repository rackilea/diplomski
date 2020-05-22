Object lockObject = new Object();
Thread t1 = new CongroThread(v, lockObject);
Thread t2 = new LibyaThread(v, lockObject);

...

class CongoThread implements Runnable {
    private ThreadValue v;
    private Object lockObject;

    public CongoThread(ThreadValue v, Object lockObject) {
    this.v = v;
    this.lockObject = lockObject,
    }
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized(lockObject)
            {
                v.setValue( "congo", "lame" );
                v.getValue();
            }
        }
    }
}