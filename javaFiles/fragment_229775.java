@Component
public class AsyncWatchServiceExecutor {
    @Autowired
    private WatchService watchService; // or create a new one here instead of injecting one

    @Async
    public void someAsyncMethod() {
        for (;;) {
            // use WatchService
        }
    }
}