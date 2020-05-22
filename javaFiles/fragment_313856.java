// A simple process.
class Process implements Runnable {

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000L);
            }
        } catch (InterruptedException ex) {
            System.out.println("Interrupted");
        }
    }

}

public void test() throws InterruptedException {
    Thread t = new Thread(new Process()) {
        @Override
        public void interrupt() {
            // Log a stack trace when iterrupted.
            new Exception("Where the hell did that come from!").printStackTrace(System.out);
            // Pass it up the chain.
            super.interrupt();
        }
    };
    t.start();
    Thread.sleep(2048);
    t.interrupt();
    t.join();
}