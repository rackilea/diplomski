class YouNameIt{
    private ExecutorService executor;

    public void start(){
        executor = Executors.newSingleThreadExecutor();
    }

    public void put(Object o){
        executor.submit(new Runnable() {
            @Override
            public void run() {
                process(o);
            }
        });
    }

    private void process(Object o) {
        //Put your processing here
    }

    public void stop(){
        executor.shutdown();
    }
}