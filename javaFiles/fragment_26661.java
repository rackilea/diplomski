@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:application.properties" })
@ComponentScan({ "org.mysample.model" })
public class PersistenceConfig {

    @Autowired
    private Environment env;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(restDataSource());
        sessionFactory.setPackagesToScan(new String[] { "org.mysample.model" });
        sessionFactory.setHibernateProperties(hibernateProperties());

          return sessionFactory;
     }

      @Bean
      public DataSource restDataSource() {
         BasicDataSource dataSource = new BasicDataSource();
          dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
          dataSource.setUrl(env.getProperty("jdbc.url"));
          dataSource.setUsername(env.getProperty("jdbc.username"));
          dataSource.setPassword(env.getProperty("jdbc.password"));
          return dataSource;
       }

       @Bean
       @Autowired
       public HibernateTransactionManager transactionManager(SessionFactory s) {
          HibernateTransactionManager txManager = new HibernateTransactionManager();
          txManager.setSessionFactory(s);
          return txManager;
       }
}