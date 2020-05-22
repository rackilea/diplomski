ExecutorService exec = Executors.newFixedThreadPool(50);
final Future f = exec.submit(task1);
exec.submit(new Runnable() {
    @Override
    public void run() {
        f.get();
        // do stuff
    }
});