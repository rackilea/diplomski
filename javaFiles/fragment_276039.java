public class CustomService extends Application<CustomConfig> { //CustomConfig extend 'io.dropwizard.Configuration'

  public static void main(String[] args) throws Exception {
    new CustomService().run(args);
  }

  @Override
  public void initialize(Bootstrap<CustomConfig> someConfigBootstrap) {
    // do some initialization
  }

  @Override
  public void run(CustomConfig config, io.dropwizard.setup.Environment environment) throws Exception {
    ... // resource registration
    environment.servlets().addFilter("Custom-Filter", CustomFilter.class)
        .addMappingForUrlPatterns(java.util.EnumSet.allOf(javax.servlet.DispatcherType.class), true, "/*");
  }
}