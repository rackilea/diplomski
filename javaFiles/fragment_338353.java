@Value("${selector.property}") private String selectorProperty;

@Autowired @Qualifier("myServiceFactory") private MyServiceFactory myServiceFactory;

private MyService myService;

@PostConstruct
public void postConstruct()
{
    this.myService = myServiceFactory.getMyService(selectorProperty);
}