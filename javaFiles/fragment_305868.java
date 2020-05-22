public abstract class AbstractSpring3JerseyTest implements ApplicationContextAware {

    private static final Logger logger = Logger.getLogger(AbstractSpring3JerseyTest.class.getName());

    private JerseyTest jerseyTest;

    private ApplicationContext applicationContext;

    @Before
    public void setup() throws Exception {
        jerseyTest.setUp();
    }

    @After
    public void tearDown() throws Exception {
        jerseyTest.tearDown();
    }

    protected Application configure(ApplicationContext appContext) {
        ResourceConfig resourceConfig = ResourceConfig.forApplication(new RestApplication());
        resourceConfig.property("contextConfig", appContext);
        resourceConfig.register(SpringLifecycleListener.class).register(RequestContextFilter.class);
        resourceConfig.packages(getResourcePackages());
        resourceConfig.register(new RestAuthenticationFilter());
        resourceConfig.property(ServerProperties.RESPONSE_SET_STATUS_OVER_SEND_ERROR, "true");
        resourceConfig.register(new LoggingFilter(logger, 20000));

        return resourceConfig;
    }

    protected abstract String[] getResourcePackages();

    public static void setDebugLevel(Level level) {
        Logger anonymousLogger = LogManager.getLogManager().getLogger("");
        Handler[] handlers = anonymousLogger.getHandlers();
        anonymousLogger.setLevel(level);
        for (Handler h : handlers) {
            if (h instanceof ConsoleHandler)
                h.setLevel(level);
        }
    }

    public final WebTarget target() {
        return jerseyTest.target();
    }

    public final WebTarget target(final String path) {
        return jerseyTest.target().path(path);
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * Set the ApplicationContext that this object runs in. Normally this call
     * will be used to initialize the object.
     * <p>
     * Invoked after population of normal bean properties but before an init
     * callback such as
     * {@link org.springframework.beans.factory.InitializingBean#afterPropertiesSet()}
     * or a custom init-method. Invoked after
     * {@link ResourceLoaderAware#setResourceLoader},
     * {@link ApplicationEventPublisherAware#setApplicationEventPublisher} and
     * {@link MessageSourceAware}, if applicable.
     * 
     * @param applicationContext
     *            the ApplicationContext object to be used by this object
     * @throws ApplicationContextException
     *             in case of context initialization errors
     * @throws BeansException
     *             if thrown by application context methods
     * @see org.springframework.beans.factory.BeanInitializationException
     */
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        jerseyTest = new JerseyTest(configure(applicationContext)) {
        };
    }
}