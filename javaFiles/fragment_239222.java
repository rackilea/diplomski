ExecutorService executor = Executors..newFixedThreadPool(2);
executor.invokeAll(Arrays.asList(new Callable<Void>(){

    @Override
    public Void call() throws Exception {
        try {
            // do your task
        } catch (InterruptedException e) {
            // your task was forced to end
        }
        return null;
    }

}), 5, TimeUnit.SECONDS);
executor.shutdown();