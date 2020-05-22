public class MainController {

    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    public void shutdown() {
        executorService.shutdown();
    }
}