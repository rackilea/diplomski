final ServiceRecording recording = ....
final AtomicBoolean started = new AtomicBoolean(false);
ScheduledExecutorService executor = Executors.newScheduledExecutor(1);
executor.scheduleAtFixedRate(new Runnable() {
    public void run() {
         //only stop if we have started
         if(started.get()) {
            recording.stop();                
         } else {
           started.set(true);
         }
         recording.start();
    }
}, 5, 5, TimeUnit.MINUTES);