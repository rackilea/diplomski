@Configuration
@EnableJpaRepositories(
        basePackages = "org.datalis.plugin.warehouse.entity", 
        entityManagerFactoryRef = "warehouseEntityManager", 
        transactionManagerRef = "warehouseTransactionManager"
    )
@EnableTransactionManagement
public class ContextWarehouseDatasource {

   ...

    @Bean   
    public EntityManager warehouseEntityManager(EntityManagerFactory emf) {
        return emf.createEntityManager();
    }