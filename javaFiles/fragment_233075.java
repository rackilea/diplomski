ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
exec.schedule(new Runnable(){
    @Override
    public void run(){
        // query database
    }
}, 0, 100, TimeUnit.MILLISECONDS);