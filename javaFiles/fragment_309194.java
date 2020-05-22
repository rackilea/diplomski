public class CustomerDaoImpl implements CustomerDao {

  private DataSource dataSource;

  public Customer findById(String id){
     checkDataSource();

     Connection con = dataSource.getConnection();
     ...
     return customer;
  }

  private void checkDataSource(){
     if(this.dataSource == null){
         throw new IllegalStateException("dataSource is not set");
     }
  }


  public void setDataSource(DataSource dataSource){
     this.dataSource = dataSource;
  }

}