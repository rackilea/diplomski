@Configuration
@Order(1)
@PropertySource("classpath:/db.properties")
public class DbConfiguration {

  /**
   * Configuration beans for establishing a connection to db1 database.
   * The primary database dataSource is automatically populated to the constructor in StoredProcedure extended class.
   */
  @Bean
  @Primary
  @ConfigurationProperties("db1.datasource")
  public DataSourceProperties db1DataSourceProperties() {
    return new DataSourceProperties();
  }

  @Bean(name = "db1")
  @Primary
  public DataSource db1DataSource() {
    return db1DataSourceProperties().initializeDataSourceBuilder().build();
  }

  /**
   * Configuration beans for establishing a connection to db2 database.
   */
  @Bean
  @ConfigurationProperties("db2.datasource")
  public DataSourceProperties db2DataSourceProperties() {
    return new DataSourceProperties();
  }

  @Bean(name = "db2")
  public DataSource db2DataSource() {
    return db2DataSourceProperties().initializeDataSourceBuilder().build();
  }