@Service
public class MyPortRegistrar {

    @Autowired
    private ConfigurableBeanFactory beanFactory;

    @Autowired
    private SpringBus bus;

    @PostConstruct
    public void createPort() {
        Port port = new WebservicePort(bus);
        beanFactory.registerSingleton("myDynamicPortName", port);
    }
}