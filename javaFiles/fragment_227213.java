public class Cache implements Closeable {
    private static final Timer TIMER = new Timer(true);

    private final File dir;
    private final long ttl;
    private final TimerTask task;

    public Cache(File dir, long ttl, long purgePeriod) {
        this.dir = dir;
        this.ttl = ttl;
        task = new TimerTask() {
            @Override
            public void run() {
                purge();
            }
        };
        TIMER.schedule(task, purgePeriod, purgePeriod);
    }

    @Override
    public void close() throws IOException {
        task.cancel();
    }

    public synchronized void purge() {
        long minTime = System.currentTimeMillis()-ttl;
        for (File file: dir.listFiles()) {
            if (file.isFile() && file.lastModified() < minTime) {
                file.delete();
            }
        }
    }
}