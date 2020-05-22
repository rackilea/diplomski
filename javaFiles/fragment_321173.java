@Configuration
public class DataAccessConfiguration {

  @Bean
  public DataSource dataSource() {
   try {
     //create data source to your database 
     ....
     return realDataSource;
   } catch (Exception) {
     //create dummy data source
     ....
     return dummyDataSource;
   }
  }
}