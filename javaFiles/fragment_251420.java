@Service
public class AlmConnectivity {

    Logger log = LoggerFactory.getLogger(AlmConnectivity.class);

    @Autowired
    @Qualifier("config")
    Config config;

    private Proxy proxy;

    private OkHttpClient client;

    @PostConstruct
    private void initProxyBean() {
        System.err.println("Config: " + config);
        proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(config.getProxyHost(), config.getProxyPort()));
    }
}