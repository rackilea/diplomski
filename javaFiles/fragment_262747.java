ScheduledExecutorService executor = new SingleScheduledThreadPool();
executor.scheduleAtFixedRate(new Runnable() {
    public void run() {
        for(File file: obj.getCHangedFiles())
            obj.processFile(file);

     }
}, 0, 1, TimeUnit.MINUTES);