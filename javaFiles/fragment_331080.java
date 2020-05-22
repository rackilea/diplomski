ExecutorService exec = Executors.newFixedThreadPool(2);
exec.execute(new Runnable() { 
// Run your database thread

});
exec.shutdown();