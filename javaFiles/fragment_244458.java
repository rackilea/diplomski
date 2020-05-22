class Task implements Runnable {

    private final AtomicInteger id;
    // Remove the stopwatch from here
    //private StopWatch totalExecTimer = new StopWatch(Task.class.getSimpleName() + ".totalExec");
    public static ConcurrentHashMap<Long, AtomicLong> histogram = new ConcurrentHashMap<Long, AtomicLong>();

    public Task(AtomicInteger id) {
        this.id = id;
    }


    @Override
    public void run() {

        // And add it here
        StopWatch totalExecTimer = new StopWatch(Task.class.getSimpleName() + ".totalExec");

        dbConnection = getDBConnection();