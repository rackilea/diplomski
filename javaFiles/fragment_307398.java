@Configuration
public class ElasticConfig {
    private static Logger logger = LoggerFactory.getLogger(ElasticConfig.class);

    @Value("${elastic.node}")
    private String elasticNode;

    @Value("${elastic.port}")
    private String elasticPort;

    @Value("${elastic.scheme}")
    private String scheme;

    RestClient lowLevelRestClient;

    @PostConstruct
    public void init() {
        logger.info("connecting with elastic");
        lowLevelRestClient = RestClient.builder(
                new HttpHost(elasticNode,Integer.parseInt(elasticPort),scheme)
        ).setMaxRetryTimeoutMillis(300000000).build();
    }

    @PreDestroy
    public void destroy() throws IOException {
        logger.info("closing connection with elastic.");
        lowLevelRestClient.close();
    }

    @Bean
    public RestClient getClient() {
        return lowLevelRestClient;
    }
    }