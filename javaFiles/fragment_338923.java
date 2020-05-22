public class Test {

    private Thread aThread;
    private Loopy aLoop;

    public static void main(String[] args) {
        final Test test = new Test();
        test.startUpdate();
        test.stopUpdate();
        test.startUpdate();

    }

    public void startUpdate() {
        aLoop = new Loopy();
        aThread = new Thread(aLoop);
        aThread.start();
    }

    public void stopUpdate() {
        if (aThread != null) {
            aLoop.finish();
        }
    }
}