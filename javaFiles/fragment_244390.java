public class MyModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(FakeDatabaseConfiguration.class).toProvider(FakeDatabaseConfigurationProvider.class);
    bind(PersonHelper.class).in(Scopes.SINGLETON);
  }

  /**
   * FakeDatabaseConfigurationProvider implementation
   */
  static class FakeDatabaseConfigurationProvider implements Provider<FakeDatabaseConfiguration> {

    @Override
    public FakeDatabaseConfiguration get() {
      FakeDatabaseConfiguration dbConfig = new FakeDatabaseConfiguration();
      dbConfig.setHost('127.0.0.1');
      dbConfig.setPort('3306');
      dbConfig.setUsername('root');
      dbConfig.setPassword('root');
      return dbConfig;
    }
  }
}