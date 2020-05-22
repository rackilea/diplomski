@Configuration
public class PersistenceConfiguration {
  private String host;
  private String port;
  private String database;
  private String schema;
  private String user;
  private String password;

  @Autowired
  public PersistenceConfiguration(Environment environment) {
    this.host = environment.getProperty("db.host");
    this.port = environment.getProperty("db.port");
    this.database = environment.getProperty("db.database");
    this.schema = environment.getProperty("db.schema");
    this.user = environment.getProperty("db.user");
    this.password = environment.getProperty("db.password");
  }
}