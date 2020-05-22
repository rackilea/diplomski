class MyDataSource implements DataSource {
    private DataSource realDataSource;

    public Connection getConnection() {
          Connection c = realDataSource.getConnection();
          // do whatever you want to do and
          return c;
    }

}