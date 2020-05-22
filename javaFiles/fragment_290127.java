ExecutorService executorService = Executors.newSingleThreadExecutor();

public void execute(YourRequestObject reqMsg, Consumer<String> consumer) {
    executorService.execute(new Runnable() {
        @Override
        public void run() {
            String result = postRequest(reqMsg);
            consumer.accept(result);
        }
    });
}