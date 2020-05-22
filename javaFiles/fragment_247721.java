@Inject
protected Provider<EntityManager> entityManagerProvider;

private EntityManager getEntityManager() {
    return entityManagerProvider.get();
}