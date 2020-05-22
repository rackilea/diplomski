@Configuration
@EnableTransactionManagement
public class Configuracion {

    @Bean(name = "mysqlNocturno")
    @ConfigurationProperties(prefix = "spring.nocturno")
    public DataSource mysqlDataSourceNocturno() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "jdbcTemplateNocturno")
    public JdbcTemplate jdbcTemplateNocturno(@Qualifier("mysqlNocturno") DataSource dsMySQL) {
        return new JdbcTemplate(dsMySQL);
    }

    @Bean(name = "transactionManagerNocturno")
    public PlatformTransactionManager transactionManagerNocturno() {
        return new DataSourceTransactionManager(mysqlDataSourceNocturno());
    }

    @Bean(name = "mysqlProduccion")
    @Primary
    @ConfigurationProperties(prefix = "spring.produccion")
    public DataSource mysqlDataSourceProduccion() {
        return  DataSourceBuilder.create().build();
    }

    @Bean(name = "jdbcTemplateProduccion")
    public JdbcTemplate jdbcTemplateProduccion(@Qualifier("mysqlProduccion") DataSource dsMySQL) {
        return new JdbcTemplate(dsMySQL);
    }

    @Bean(name = "transactionManagerProduccion")
    public PlatformTransactionManager transactionManagerProduccion() {
        return new DataSourceTransactionManager(mysqlDataSourceProduccion());
    }

}