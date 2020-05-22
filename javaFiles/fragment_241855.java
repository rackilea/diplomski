@Configuration
@PropertySource("classpath:database.properties")
public class ContextConfigutarion {

    @Autowired
    private Environment env;

    @Bean
    public BasicDataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(com.mysql.jdbc.Driver.class.getName());
        dataSource.setUrl(env.getRequiredProperty("database.url"));
        dataSource.setUsername(env.getRequiredProperty("database.user));
        // Other properties
        return dataSource;
    }

}