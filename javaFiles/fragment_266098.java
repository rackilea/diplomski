@EnableTransactionManagement
@ComponentScan({ "com.project.form.config","com.project.form.dao" })
@PropertySource(value = { "classpath:application.properties" })
@Configuration
public class SpringDBConfig {

    @Autowired
    private Environment environment;

    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource db) {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(db);
        sessionFactory.setPackagesToScan(new String[] { "com.project.form.model" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        return properties;
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource db = new DriverManagerDataSource();
        db.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        db.setUrl(environment.getRequiredProperty("jdbc.url"));
        db.setUsername(environment.getRequiredProperty("jdbc.username"));
        db.setPassword(environment.getRequiredProperty("jdbc.password"));
        System.out.println("## getDataSource: " + db);
        return db;
    }

    @Bean
    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate(DataSource db) {
        if(db!=null){
            System.out.println("Not Null!");
        }
        return new NamedParameterJdbcTemplate(db);
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory s) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(s);
        return txManager;
    }
}