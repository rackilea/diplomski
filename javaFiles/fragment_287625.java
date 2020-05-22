public interface BillingService {

    public BillingDAO getBalance();

}

@Service(value = "billingService")
@Transactional("transactionManager")
public class BillingServiceImpl implements BillingService {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    // Transactional // you can have method level transaction manager, which can be different from one method to another
    public BillingDAO getBalance(long id) {
        return sessionFactory.getCurrentSession().get(BillingDAO.class, id);
    }

}

public interface StockService {

    public StockDAO getStock();

}

@Service(value = "stockService")
@Transactional("transactionManager")
public class StockServiceImpl implements StockService {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private BillingService billingService;

    @Override
    // Transactional
    public StockDAO getStock(long id) {

        // if you want to use billing related changes, use billing server which is autowired
        BillingDAO billingDAO = billingService.getBalance(id);

        return sessionFactory.getCurrentSession().get(StockDAO.class, billingDAO.getStockId());
    }

}

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

    @Autowired
    private ApplicationContext appContext;

    @Autowired
    private ApplicationProperties applicationProperties;

    @Bean
    public HikariDataSource getDataSource() {
        HikariDataSource dataSource = new HikariDataSource();

        dataSource
            .setDataSourceClassName(applicationProperties.getHibernateDatasource());
        dataSource.addDataSourceProperty("databaseName", applicationProperties.getRdbmsDatabase());
        dataSource.addDataSourceProperty("portNumber", applicationProperties.getRdbmsPort());
        dataSource.addDataSourceProperty("serverName", applicationProperties.getRdbmsServer());
        dataSource.addDataSourceProperty("user", applicationProperties.getRdbmsUser());
        dataSource.addDataSourceProperty("password", applicationProperties.getRdbmsPassword());

        return dataSource;
    }

    @Bean("transactionManager")
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager manager = new HibernateTransactionManager();
        manager.setSessionFactory(hibernate5SessionFactoryBean().getObject());
        return manager;
    }

    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean hibernate5SessionFactoryBean() {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(appContext
                .getBean(HikariDataSource.class));
        localSessionFactoryBean.setAnnotatedClasses(BillingDAO.class);

        Properties properties = new Properties();

        // properties.put("hibernate.current_session_context_class","thread");
        // // because I am using Spring, it will take care of session context
        /*
         * 
         * Spring will by default set its own CurrentSessionContext
         * implementation (the SpringSessionContext), however if you set it
         * yourself this will not be the case. Basically breaking proper
         * transaction integration.
         * 
         * Ref:
         * https://stackoverflow.com/questions/18832889/spring-transactions-and-hibernate-current-session-context-class
         */
        properties.put("hibernate.dialect",
                applicationProperties.getHibernateDialect());

        properties.put("hibernate.hbm2ddl.auto", applicationProperties.getHibernateHbm2ddlAuto());
        properties.put("hibernate.show_sql", applicationProperties.getShowSql());
        // properties.put("hibernate.hbm2ddl.import_files",
        // "/resource/default_data.sql"); // this will execute only
        // when hbm2ddl.auto is set to "create" or "create-drop"
        // properties.put("connection.autocommit", "true");

        localSessionFactoryBean.setHibernateProperties(properties);
        return localSessionFactoryBean;
    }
}