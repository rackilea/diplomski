public class ThreadTest {

    private static final long startTime = System.currentTimeMillis();

    public static void main(String args[]) {
        Thread ct = new ChildThread();
        ThreadTest.print("starting child threads in MAIN");
        ct.start();
        try {
            ThreadTest.print("about to start wait() in MAIN");
            synchronized (ct) {
                ct.wait();
            }
            ThreadTest.print("after wait() in MAIN");
        } catch (Exception e) {
            ThreadTest.print("Exception in MAIN");
        }
    }

    public static void print(String s) {
        System.out.println("Millisecond : " + (System.currentTimeMillis() - ThreadTest.startTime) + "\t: " + s);
    }

    private static final class ChildThread extends Thread {
        public void run() {
            try {
                ThreadTest.print("before thread notifyAll in CHILD");
                synchronized (this) {
                    notifyAll();
                }
                ThreadTest.print("notifyAll over, sleep starts in CHILD");
                Thread.sleep(1000);
                ThreadTest.print("after thread sleep in CHILD");

            } catch (Exception e) {
                ThreadTest.print("Exception in CHILD");
            }
            ThreadTest.print("End of run method in CHILD");
        }
    }
}