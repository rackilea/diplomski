@Configuration
@ComponentScan
@EnableTransactionManagement
public class SpringBeanConfiguration { 

   @Bean
   public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
      LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
      em.setPersistenceUnitName("myPersistenceContext");
      em.setDataSource(dataSource());
      em.setPackagesToScan(new String[] { "xxx.xxx.xxx" });

      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
      em.setJpaVendorAdapter(vendorAdapter);
   //   em.setJpaProperties(additionalProperties());

      return em;
   }

   @Bean
   public DataSource dataSource(){
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setDriverClassName("com.mysql.jdbc.Driver");
      dataSource.setUrl("jdbc:mysql://localhost:3306/jboss_test");
      dataSource.setUsername( "root" );
      dataSource.setPassword( "root" );
      return dataSource;
   }

   @Bean
   public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
      JtaTransactionManager transactionManager = new JtaTransactionManager();
     // transactionManager.setEntityManagerFactory(emf);

      return transactionManager;
   }

   @Bean
   public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
      return new PersistenceExceptionTranslationPostProcessor();
   }