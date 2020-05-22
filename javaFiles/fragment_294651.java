@PersistenceContext
private EntityManager entityManager;

protected final EntityManager getEntityManager() {
    return entityManger;
}