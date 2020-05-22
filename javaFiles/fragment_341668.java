public class Application extends io.dropwizard.Application<Configuration>{

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        MetricRegistry metrics = environment.metrics();
        environment.jersey().register(new HelloResource(metrics));

    }

    public static void main(String[] args) throws Exception {
        new Application().run("server", "/home/artur/dev/repo/sandbox/src/main/resources/config/test.yaml");
    }
}