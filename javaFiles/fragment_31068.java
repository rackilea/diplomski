@Configuration
@EnableTransactionManagement
@ComponentScan("pl.mbrnwsk.sklep")
public class AppConfiguration {

    public String hbm2ddl_auto = "update";

    public AppConfiguration(){
        System.out.println("AppConfiguration");
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.hsqldb.jdbcDriver");
        ds.setUrl("jdbc:hsqldb:file:/SklepDB/");
        ds.setUsername("SA");
        ds.setPassword("");
        return ds;
    }

    @Bean
    public SessionFactory sessionFactory() {
        LocalSessionFactoryBuilder ss = new LocalSessionFactoryBuilder(dataSource());
        ss.scanPackages("pl.mbrnwsk.sklep.model");
        ss.setProperty("hibernate.show_sql", "true");
        ss.setProperty("hibernate.hbm2ddl.auto", hbm2ddl_auto);
        ss.setProperty("hibernate.dialect",
                "org.hibernate.dialect.HSQLDialect");
        return ss.buildSessionFactory();
    }

    @Bean
    public PlatformTransactionManager txManager(){
        return new HibernateTransactionManager(sessionFactory());   
    }
}