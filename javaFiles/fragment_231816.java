public class EntityManagerProducer implements Serializable {

    @Inject
    @PersistenceUnitName(value="generalPU")
    private EntityManagerFactory entityManagerFactory;

    @Produces
    @TransactionScoped
    protected EntityManager createTranEntityManager() {
        return this.entityManagerFactory.createEntityManager();
    }

    protected void closeEntityManager(@Disposes EntityManager entityManager){
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }
}