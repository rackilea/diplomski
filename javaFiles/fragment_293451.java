public class MyRunnable implements Runnable {
    private MyObject obj;
    public MyRunnable(MyObject obj) {
       this.obj = obj;
    }
    public void run() {
       obj.someMethod();
    }
}