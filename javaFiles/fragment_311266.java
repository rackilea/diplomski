public <T> int deleteAllEntities(Class<T> entityType) {
    CriteriaBuilder builder = em.getCriteriaBuilder();
    CriteriaDelete<T> query = builder.createCriteriaDelete(entityType);
    query.from(entityType);
    return em.createQuery(query).executeUpdate();
}