@Configuration
@EnableTransactionManagement
@ComponentScan({"com.alti.hrportal.configuration"})
public class HibernateConfiguration {

    private static final PropertiesLoader propertiesLoader1 = new PropertiesLoader();
    Properties propHrPortal = propertiesLoader1.load("application.properties");

    private static final PropertiesLoader propertiesLoader2 = new PropertiesLoader();
    Properties propErp = propertiesLoader2.load("applicationErp.properties");

    @Bean
    public LocalSessionFactoryBean sessionFactory2() {
        LocalSessionFactoryBean sessionFactory2 = new LocalSessionFactoryBean();
        sessionFactory2.setDataSource(dataSource2());
        sessionFactory2.setPackagesToScan(new String[]{"com.alti.hrportal.model"});
        sessionFactory2.setHibernateProperties(hibernateProperties2());
        return sessionFactory2;
    }


    @Bean(name="txManager1")
    public HibernateTransactionManager transactionManager1() {
        HibernateTransactionManager txManager1 = new HibernateTransactionManager();
        txManager1.setSessionFactory(sessionFactory1().getObject());
        return txManager1;         
    }

    @Bean(name="txManager2")
    public HibernateTransactionManager transactionManager2() {
        HibernateTransactionManager txManager2 = new HibernateTransactionManager();
        txManager2.setSessionFactory(sessionFactory2().getObject());
        return txManager2;
    }
    // Omitted other not modified configuration.
}