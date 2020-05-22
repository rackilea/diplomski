@Configuration
@EnableJpaRepositories(
        basePackages = "org.datalis.plugin.production.entity", 
        entityManagerFactoryRef = "productionEntityManager",  
        transactionManagerRef = "productionTransactionManager" 
    )
@EnableTransactionManagement
public class ContextProductionDatasource {

  ...

 @Primary
    @Bean   
    public EntityManager productionEntityManager(EntityManagerFactory emf) {
        return emf.createEntityManager();
    }