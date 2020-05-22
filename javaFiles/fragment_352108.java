public class Worker implements Runnable {
    Thread t;
    public Worker() {
        t = new Thread(this);
    }
    @Override
    public void run() {
        //do stuff here
    }
    public void start() {
        t.start();
    }
}