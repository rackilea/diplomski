package dao; 
public class dataSource extends DriverManagerDataSource { 
 public dataSource() { 
 // TODO Auto-generated constructor stub 
  this.setDriverClassName("com.mysql.jdbc.Driver"); 
  this.setUrl("jdbc:mysql://.../....."); 
  this.setUsername(""); this.setPassword(""); 
   }
}