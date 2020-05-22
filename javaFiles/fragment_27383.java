public class App {

    public static void main(String[] args) throws InterruptedException {
        MainThread mainThread = new MainThread();
        mainThread.start();
        Thread.sleep(1);    // <== This line is needed as otherwise, the next line will 
                            //      interrupt the thread, even before it has started running!
        mainThread.childThread.interrupt();
    }
}