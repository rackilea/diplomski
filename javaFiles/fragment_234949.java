@Configuration
@PropertySource("classpath:jdbc.properties")
public class HibernateConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource(){  
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(env.getProperty("db.driverClass"));
        dataSource.setJdbcUrl(env.getProperty("db.jdbcUrl"));
        dataSource.setUser(env.getProperty("db.user"));
        dataSource.setPassword(env.getProperty("db.password"));
        dataSource.setMaxPoolSize(50);
        dataSource.setMinPoolSize(5);
        dataSource.setMaxConnectionAge(1800);
        dataSource.setMaxIdleTime(1800);
        dataSource.setAutoCommitOnClose(false);
        dataSource.setInitialPoolSize(5);
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource){
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", map.get("db.dialect"));
        hibernateProperties.setProperty("hibernate.jdbc.batch_size", "0");
        localSessionFactoryBean.setHibernateProperties(hibernateProperties);
        localSessionFactoryBean.setDataSource(dataSource);
        return localSessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory){
        return new HibernateTransactionManager(sessionFactory);
    }
}