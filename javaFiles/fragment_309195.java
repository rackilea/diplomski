public class CustomerDaoImpl implements CustomerDao {

  private DataSource dataSource;

  public CustomerDaoImpl(DataSource dataSource){
      if(dataSource == null){
        throw new IllegalArgumentException("Parameter dataSource must not be null");
     }
     this.dataSource = dataSource;
  }

  public Customer findById(String id) {    
      Customer customer = null;
     // We can be sure that the dataSource is not null
     Connection con = dataSource.getConnection();
     ...
     return customer;
  }
}