@PersistenceUnit
private EntityManagerFactory entityManagerFactory;

protected final EntityManager getEntityManager() {
    return entityManagerFactory.createEntityManager();
}