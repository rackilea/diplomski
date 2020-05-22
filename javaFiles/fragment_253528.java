ExecutorService exec = Executors.newFixedThreadPool(1); //1 thread at a time
for (int count = 0; count < 4; count++) {
    if (it.hasNext()) {
        File current = new File((String) it.next());
        exec.execute(new Runnable() {
             @Override
             public void run() {
                 upload(current);
             }
        });
     }
}
exec.shutdown();
exec.awaitTermination(900, TimeUnit.SECONDS);