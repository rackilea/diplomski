public class MyDataSourceFactory {
    public DataSource createDataSource() {
        BasicDataSource target = new BasicDataSource();
        if (condition) {
            target.setDriverClassName("com.mysql.jdbc.Driver");                
            target.setUrl("jdbc:mysql://localhost/test?relaxAutoCommit=true"); 
        } else { ... }
        return target;
    }
}