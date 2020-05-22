public class DatastoreModule extends AbstractModule {

  private final Environment environment;
  private final Config config;

  public DatastoreModule(Environment environment, Config config) {
    this.environment = environment;
    this.config = config;
  }

  ...

}