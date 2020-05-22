@Component
public class AsyncInitializer {
    @Autowired
    private AsyncWatchServiceExecutor exec;

    @PostConstruct
    public void init() {
        exec.someAsyncMethod();
    }
}