public class GuiceJerseyManualBridge extends io.dropwizard.Application<Configuration> {

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        JerseyEnvironment jersey = environment.jersey();

        // create the Guice env and its dependencies
        Injector i = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                Map<String, String> props = new HashMap<>();
                props.put("testme", "Hello World Guice Inject Test");
                Names.bindProperties(binder(), props);
                bind(HelloResource.class).in(Singleton.class);
            }
        });

        // get instance

        HelloResource resourceInstance = i.getInstance(HelloResource.class);
        jersey.register(new AbstractBinder() {

            @Override
            protected void configure() {
                // teach jersey about your guice dependency 
                bind(resourceInstance).to(HelloResource.class);
            }
        });

        jersey.register(HelloResource.class); // register resource - jersey will discover this from the binding
    }

    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {
        super.initialize(bootstrap);
    }

    public static void main(String[] args) throws Exception {
        new GuiceJerseyManualBridge().run("server", "/home/artur/dev/repo/sandbox/src/main/resources/config/test2.yaml");
    }

    @Path("test")
    @Produces(MediaType.APPLICATION_JSON)
    public static class HelloResource {


        @Inject
        @Named("testme")
        private String testString;

        public HelloResource() {
            System.err.println("I am created now");
        }

        @GET
        @Path("test")
        public String test(String x) {
            return testString;
        }

    }

}