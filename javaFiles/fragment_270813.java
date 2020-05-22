public class ConnectionProviderHikariCP implements IConnectionProvider {

  private static final ConnectionProviderHikariCP INSTANCE;
  private final HikariDataSource hikariDataSource;
  private AtomicBoolean initialized;
  //class initializer:
  static
  {
     INSTANCE = new ConnectionProviderHikariCP();
  }

  private ConnectionProviderHikariCP() {
     hikariDataSource = new HikariDataSource();
     initialized = new AtomicInteger();
  }

  public static ConnectionProviderHikariCP getInstance() {
     return INSTANCE;
  }

  @Override
  public void init(String jdbcUrl, String user, String password) {
     if (initialized.compareAndSet(false, true)) {
        hikariDataSource.setJdbcUrl(jdbcUrl);        
        hikariDataSource.setUsername(user);
        hikariDataSource.setPassword(password);
     }
     else {
        throw new IllegalStateException("Connection provider already initialized.");
     }
  }

  @Override
  public Connection getConnection() throws SQLException {
     if (initialized.get()) {
        return hikariDataSource.getConnection();
     }

     throw new UnsupportedOperationException("Debe inicializar mediante el método Init() primero!!!!!."); 
  }
}