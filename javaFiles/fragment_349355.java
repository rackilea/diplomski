public static EntityManager getEntityManager() {
    EntityManager entityManager = Persistence
            .createEntityManagerFactory("NewPersistenceUnit")
            .createEntityManager();

    return entityManager;
}