public class MyRunnable implements Runnable {
    private final String s;

    public MyRunnable(Stirng s) {
        this.s = s;
    }

    public void run() {
        // do something with s
    }
}

Thread t1 = new Thread(new MyRunnable("s1"));
Thread t2 = new Thread(new MyRunnable("s2"));
t1.start();
t2.start();