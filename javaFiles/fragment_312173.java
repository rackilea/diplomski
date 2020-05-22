public class Execution implements Runnable {
    public String name;

    protected long startedAtMs;

    // total timeout in ms
    protected long timeoutMs;


    // rate: 1 execution per 2 ms
    private long rateMs = 2;

    // when was the previousExecution
    private long prevExecutionMs;

    // action to run each 1 ms
    protected Runnable action;

    public Execution(String name, double et, Runnable action) {
        this.name = name;
        this.action = action;
        this.timeoutMs = (long) (et * 1000);

    }

    public void run() {
        startedAtMs = System.currentTimeMillis();
        prevExecutionMs = startedAtMs;

        while (true) {
            // check if the job was interrupted
            if (Thread.interrupted()) {
                return;
            }

            long now = System.currentTimeMillis();

            // check if it's time to finish
            if (now - startedAtMs > timeoutMs) {
                break;
            }

            // check if it's time to run the action
            if(now - prevExecutionMs > rateMs){
                // run the action
                action.run();
                // update the executed time
                prevExecutionMs = now;
            }
        }

    }

    // this getter could be used to get the running time
    public double getTimeToDisplay() {
        return (System.currentTimeMillis() - startedAtMs) / 1000D;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Execution("exec", 0.5, new Runnable() {
            @Override
            public void run() {
                System.out.println(new Date());
            }
        }));

        //starts the thread
        thread.start();

        //waits to finish
        thread.join();

        System.out.println("Done!");
    }
}