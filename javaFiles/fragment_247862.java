public class MyThread extends Thread {
    private String data;
    public MyThread(String data) {
        this.data = data;
    }

    public void run() { /* process data */ }
}