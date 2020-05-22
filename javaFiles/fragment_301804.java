ExecutorService forLoopExecutor = Executors.newSingleThreadExecutor();
    Future<?> future = forLoopExecutor.submit(new Runnable() {

        @Override
        public void run() {
            //your for loop here
        }
    });
    try {
        future.get(1, TimeUnit.SECONDS); //your timeout here
    } catch (TimeoutException e) {
        future.cancel(true);
    }
    forLoopExecutor.shutdownNow();
    //proceed with the rest of your code
    forLoopExecutor.submit(aRunnableForInstructions2);