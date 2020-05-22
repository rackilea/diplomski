@Configuration
@EnableJdbcRepositories
public class MetricStoreRepositoryConfig extends JdbcConfiguration {
    @Autowired
    private DataSource dataSource;

    @Bean
    NamedParameterJdbcOperations operations() {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    NamingStrategy namingStrategy() {
        return new NamingStrategy() {
            @Override
            public String getSchema() {
                return "metric";
            }
        };
    }
}