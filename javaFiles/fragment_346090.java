public class RDS {
  private volatile DataSource delegate;

  public Connection getConnection() throws SQLException {
    return delegate.getConnection();
  }

  private void reload(Configuration config) {
    DataSource old = null;
    synchronized(this) {
      old = delegate;
      delegate = createDataSource(config);
    }
    destroyDataSource(old);
  }
}