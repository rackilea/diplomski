@Inject
@Named("testCon")
private TestConsumer test;

private String name;

// Getters and Setters

// Logger LOG = LoggerFactory.getLogger(HelloWorldBean.class);

public void convertNameToUpperCase2(AjaxBehaviorEvent event) {
    name = test.convertNameToUpperCase2(name);
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}
 }