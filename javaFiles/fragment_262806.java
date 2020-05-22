public class Stuff {
    private LongProperty time = new SimpleLongProperty(this, "time");
    private Executor execute;

    public Stuff(Clock clock) {
        time.bind(clock.getValue);
        execute = Executors.newCachedThreadPool(runnable -> {
            Thread t = new Thread(runnable);
            t.setDaemon(true);
            return t;
        });
    }

    public void someAction() {
        for(int i = 0; i < 5; i++) {
            execute.execute(scheduleTask(i));
        }
    }

    public Runnable scheduleTask(int i) {
        time.addListener((obs, oldV, newV) -> {
            System.out.println("Task " + i + ": " + Thread.currentThread());
        });
    }
}