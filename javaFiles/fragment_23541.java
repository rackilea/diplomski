public class StarterBasicAutoconfigTest {

    ConfigurableApplicationContext context;

    @After
    public void teardown() {
        if (context != null && context.isRunning())
            context.close();
    }


    @Test
    public void sometest() {
        context = MinStarterBasicApp.setupWebApp("profile1");

        ServiceRegistry registry = context.getBean(ServiceRegistry.class);
        context.close();

        Mockito.verify(registry, times(1)).register(any());
        Mockito.verify(registry, times(1)).deregister(any());
}