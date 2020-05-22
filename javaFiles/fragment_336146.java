@Configuration
@PropertySource("app.properties")
public class DataConfig {
    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(env.getProperty("testapp.db.driver"));
        ds.setUrl(env.getProperty("testapp.db.url"));
        ds.setUsername(env.getProperty("testapp.db.username"));
        ds.setPassword(env.getProperty("testapp.db.password"));
        return ds;
    }
}