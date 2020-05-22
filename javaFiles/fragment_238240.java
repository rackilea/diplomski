public class LongAction {
    public AtomicBoolean finished = new AtomicBoolean();
    private final Handler h;      

    /* attributes you need */

    public LongAction(Handler h /* parameters you need to initialice attibutes */) {
        this.h = h;
        // Initialization
    }

    public void doLongTask() {
        finished.set(false);
        new Runnable() {
            @Override
            public void run() {
                // your long task
                finished.set(true);
            }
        }.run();
        new Runnable() {
            @Override
            public void run() {
                while (!finished.get()) {
                }
                Message m = Message.obtain();
                m.what = 0;
                m.arg1 = 50;
                h.sendMessage(m);
            }
        }.run();
    }
}