@Component
public class DatabaseQueries {

@Inject 
private ComboPooledDataSource comboPooledDataSource;

public List<Records> getData() {
    Connection connection = comboPooledDataSource.getConnection();
    // ... create sql query and execute 
}