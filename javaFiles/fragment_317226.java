public class MyRunnable implements Runnable {

    MyInterface interface;

    public MyRunnable(MyInterface interface) {
        this.interface = interface;
    }

    public void run() {
        interface.onRunnableDone("Hello")
    }
}