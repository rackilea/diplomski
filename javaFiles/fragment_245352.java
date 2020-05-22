@Configuration
@EnableTransactionManagement
public class PersistenceConfiguration {

    @Value("${spring.datasource.url}")
    private String jdbcUrl;
    // ...

    @Bean
    public DataSource dataSource() {
       DriverManagerDataSource dataSource = new DriverManagerDataSource();
       dataSource.setUrl(jdbcUrl);
       // ...
    }
}