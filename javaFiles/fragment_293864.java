@SpringBootApplication
@EnableAsync
public class Application extends AsyncConfigurerSupport {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("GithubLookup-");
        executor.initialize();
        return executor;
    }
}

@Component
class AppRunner implements CommandLineRunner {

    public static final Logger logger = LoggerFactory.getLogger(AppRunner2.class);
    @Autowired
    private DatabaseWriter writer;

    @Override
    public void run(String... args) throws Exception {
        logger.info("---  start ---");
        writer.testAsync();
        logger.info("--- stop ---");
    }
}

@Component
class DatabaseWriter {
    @Async
    public Future<Object> testAsync() throws InterruptedException {
        Thread.sleep(5000);
        AppRunner.logger.info("end of DatabaseWriter.testAsync() method");
        return null;
    }
}