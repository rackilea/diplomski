public class DBManager {
  public static final HikariDataSource hikariDS;

  static {
    String resourceName = "re/iprocu/coperativeerp/config/db/dbSettings.properties";
    ClassLoader loader = Thread.currentThread().getContextClassLoader();
    Properties props = new Properties();
    try(InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
      props.load(resourceStream);
    } catch (IOException ex) {
      Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
    }

    final HikariConfig hikariConfig = new  HikariConfig(props);
    hikariConfig.setMaximumPoolSize(30);
    hikariConfig.setMinimumIdle(10);
    hikariConfig.setPoolName("TripPool");
    hikariConfig.setConnectionTimeout(1000);
    hikariConfig.setConnectionTestQuery("SELECT 1");
    hikariConfig.setAutoCommit(true);
    hikariConfig.setInitializationFailFast(false);
    hikariConfig.setLeakDetectionThreshold(2000);
    DBManager.hikariDS = new HikariDataSource(hikariConfig);
  }
}