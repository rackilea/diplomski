@Service
public class SomeService {

    private final SentimentClient firstClient;

    @Autowired
    private SomeService(SentimentClient firstClient) {
        this.firstClient = firstClient;
    }

    // Some business logic here 
}