@ApplicationScoped
public class InitializationResourceBean {

    private static final Logger LOG = Logger.getLogger(InitializationResourceBean.class);

    @Inject
    HealthCheck healthCheck;

    public void listen(@Observes ApplicationInitialisationListener.SomeDummyEvent event) {
    }

    @PostConstruct
    public void init() {
        // Do something with healthCheck
    }

    @PreDestroy
    public void destroy() {
        // Do some other thing with healthCheck
    }
}