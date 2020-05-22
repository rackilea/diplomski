@Service
public class ExampleService {

    private final Logger logger;

    public ExampleService(Logger logger) {
        this.logger = logger;
        logger.info("Im working");
    }
}