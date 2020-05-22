public class Task implements Runnable {
    private final TaskObject object;
    private int executionTick = 0;

    public Task(final TaskObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        this.object.start();
        try {
            while (this.object.isActive()) {
                if (this.executionTick == 10) {
                    this.object.stop();
                } else {
                    System.out.println(this.executionTick++ + ": " + this.object.getName());
                    Thread.sleep(1000L);
                }
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}