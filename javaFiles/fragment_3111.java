public <T> List<T> findAllEntitiesOrderedBy(Class<T> entityClass, String orderByColumn, boolean ascending) {
    CriteriaBuilder builder = em.getCriteriaBuilder();

    CriteriaQuery<T> criteria = builder.createQuery(entityClass);
    Root<T> entityRoot = criteria.from(entityClass);
    criteria.select(entityRoot);
    javax.persistence.criteria.Order order = ascending ? builder.asc(entityRoot.get(orderByColumn))
        : builder.desc(entityRoot.get(orderByColumn));
    criteria.orderBy(order);
    return em.createQuery(criteria).getResultList();
}