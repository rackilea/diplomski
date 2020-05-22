public class MyApplication extends Application {

    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Override
    public void start(Stage primaryStage) {
        // ...
    }

    @Override
    public void stop() {
        executorService.shutdown();
    }
}