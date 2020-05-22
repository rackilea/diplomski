public class MyThread extends Thread {

    private WeakReference<Button> mButton;

    public MyThread(Button button) {
        mButton = new WeakReference(button);
        // Use this button where-ever you want
    }

    public void run() {
        //thread business
    }
}
......
Button btn = ...;
public doSomething() {
    MyThread thr = new MyThread(btn);
    thr.start();
}