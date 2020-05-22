@Configuration
public class DataSourceConfig {

@Value( "${spring.datasource.xyz.jndi-name}" )
private String xyzJndiName;

@Value( "${spring.datasource.test.jndi-name}" )
private String testJndiName;

@Bean(name = "XyzDataSource")
public DataSource getXyzDataSource() throws Exception {        
    JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
    return dataSourceLookup.getDataSource(xyzJndiName);
}   

@Bean(name = "TestDataSource")
public DataSource getTestDataSource() throws Exception {        
    JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
    return dataSourceLookup.getDataSource(testJndiName);
}