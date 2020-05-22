@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = {"mobi.puut.database"})
public class DatabaseConfig {

    @Bean
    public LocalSessionFactoryBean sessionFactory() {

        //  mobi.puut.entities
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(
                new String[]{"mobi.puut.entities"});
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(
            SessionFactory sessionFactory) {

        HibernateTransactionManager txManager
                = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);

        return txManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        // dataSource.setUrl("jdbc:mysql://localhost:3306/wallet?createDatabaseIfNotExist=true");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Wallet");
        dataSource.setUsername("testuser");
        dataSource.setPassword("testpassword");

        return dataSource;
    }

    Properties hibernateProperties() {

        Properties properties = new Properties();
//        properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        return properties;
    }
}