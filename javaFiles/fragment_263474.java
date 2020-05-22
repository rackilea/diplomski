class ToSomethingRunnable implements Runnable {
    void run() {
        // Add your customized code here to update the contents in the database.
    }
}

ScheduledThreadPoolExecutor executor = Executors.newScheduledThreadPool(1);
ScheduledFuture<?> future = executor.scheduleAtFixedRate(new ToSomethingRunnable(), 
     0, 1, TimeUnit.MINUTES); 

// at some point at the end
future.cancel();
executor.shutdown();