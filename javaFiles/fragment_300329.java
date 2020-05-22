@Configuration
public class DbConfig {

  @Value("${url:localhost}")
  String dbUrl;

  // rest for driver, user, pass etc

  public DataSource createDatasource() {
    // here you use some DataSourceBuilder to configure connection
  }
}