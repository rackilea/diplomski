@ContextConfiguration(locations = "test-beans.xml", 
                      loader = TestContextLoader.class)
public class GreetingServiceTest extends SerenityStories {

    @Autowired
    private GreetingService greetingService;

    private String greeting;

    @When("I want a greeting")
    public void whenIWantAGreeting() {
        greeting = greetingService.getGreeting();
    }

    @Then("I shall be greeted with \"$greeting\"")
    public void thenIShallBeGreetedWith(String greeting) {
        assertEquals(greeting, this.greeting);
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), this);
    }

    @BeforeStories
    public final void beforeStories() {
        AutowireCapableBeanFactory beanFactory = getContext().getAutowireCapableBeanFactory();
        beanFactory.autowireBeanProperties(this, AutowireCapableBeanFactory.AUTOWIRE_NO, false);
        beanFactory.initializeBean(this, getClass().getName());
    }

    private ApplicationContext getContext() {
        return SpringClassRuleHack.getTestContextManager(getClass())
            .getTestContext()
            .getApplicationContext();
    }
}