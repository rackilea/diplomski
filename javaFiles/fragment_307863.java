@SpringBootApplication
@EnableAutoConfiguration
public class Application {

    ExecutorService executorService = Executors.newCachedThreadPool();

    public Application() {
        executorService.submit(() -> {
            while (true)
            {
                if (Thread.interrupted()) break;
            }
        });
    }

    public static void main(String[] args) {
       SpringApplication.run(Application.class, args);
    }

    @PreDestroy
    public void tearDownExecutor() {
        executorService.shutdownNow();
    }
}

@Service
public class FaultyService {
    public FaultyService(){
        throw new RuntimeException("error");
    }
}