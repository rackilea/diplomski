@Autowired
private ApplicationContext applicationContext;

@PostConstruct
public void addFooServices() {

    for (... : this.applicationContext.getBeansOfType(FooService.class)) {
        // do something with each
}