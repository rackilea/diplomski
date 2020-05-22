@Service
public class ExampleService {
    @Autowired
    private Logger logger;

    public ExampleService() {
        this.logger=logger;
        logger.info("Im working");
    }
}