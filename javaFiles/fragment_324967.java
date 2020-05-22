@Compontent
public class DataSourceValdationBean {

  private DataSource dataSource;

  @Autowire
  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @PostConstruct
  public void validateDataSource() {
    try {
       Connection c = dataSource.getConnection();
       Statement s = c.createStatement();
       s.excuteQuery("SELECT 1");  // you have to change this depending on your DBMS
    } catch (SQLException | SQLTimeoutException e) {
       // log error and throw exception
    }
  }

}