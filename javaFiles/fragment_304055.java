@RequiredArgsConstructor
public class DataFetchTask {

    private final String script;
    private final TimeInterval timeInterval;
    private final Range timeRange;

    @Autowired
    YahooFinDataFetcher yahooFinDataFetcher = new YahooFinDataFetcher();

   ...