@Bean
@Primary // this will override the datasource autoconfiguration and use your own everywhere
public DataSource dataSource() {
    // Open Connection
    // Check Database
    // Close Connection
    // IF File corrupted delete files
    // create regular data source
}