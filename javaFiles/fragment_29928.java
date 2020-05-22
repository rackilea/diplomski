@Configuration
    @ComponentScan(basePackages = "com.kla.it")
    @PropertySource(value = {"classpath:database.properties"})
    public class DatabaseConfig {

        @Autowired
        private Environment env;

        @Bean(name="ds")
        public DataSource getDataSource(){
            System.out.println("++++++++++++++++DATABASE++++++++++++++START++++++++++++");
            System.out.println("Method to crate data source");
            DriverManagerDataSource ds = new DriverManagerDataSource();
            ds.setDriverClassName("net.snowflake.client.jdbc.SnowflakeDriver");
            ds.setUrl(env.getRequiredProperty("db.url"));
            ds.setUsername(env.getRequiredProperty( "db.username"));
            ds.setPassword(env.getRequiredProperty( "db.password"));
            return ds;
        }

        @Bean(name="template")
        public JdbcTemplate jdbcTemplate(@Qualifier("ds")DataSource ds) {
            System.out.println("Jdbc template method called.");
            JdbcTemplate template = new JdbcTemplate(ds);
            template.setResultsMapCaseInsensitive(true);
            System.out.println("++++++++++++++++DATABASE++++++++++++++END+++++++++++");
            return template;
        }
    }   


@Import(DatabaseConfig.class) /* add this line to aggrgate java configuration classes*/
@Configuration
@EnableWebMvc
@ComponentScanenter code here(basePackages = "com.kla.it")
@PropertySource(value = {"classpath:global.properties"})
public class GlobalWebConfig extends WebMvcConfigurerAdapter {
}