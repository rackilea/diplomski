@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:hibernate.properties" })
@EnableJpaRepositories
@ComponentScan(basePackages = {
    "model.service"})
public class PersistenceJPAConfig {

   ....

   @Bean
   public LocalContainerEntityManagerFactoryBean entityManagerFactory() { LocalContainerEntityManagerFactoryBean em = new 
     LocalContainerEntityManagerFactoryBean();
     em.setDataSource(dataSource());
     em.setPackagesToScan(new String[] { "model.entities" });

     JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
     em.setJpaVendorAdapter(vendorAdapter);
     em.setJpaProperties(additionalProperties());
     return em;
   }

....