class Robot{
    final ExecutorService movingService = Executors.newSingleThreadExecutor();
    private volatile Future<?> request; //you can use a Deque or a List for multiple requests
    public void forward(int... args){
         request = movingService.submit(new Runnable(){
               public void run(){
                      Robot.this.move(args);
               }
         });
    }
    public void stop(){
       request.cancel(true);
    }

}