@Configuration
@EnableTransactionManagement
public class PersistenceJPAConfig{

   @Bean
   public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
      ...
   }

   @Bean
   public PlatformTransactionManager transactionManager(){
      //configure JTA transaction manager
      return transactionManager;
   }
}