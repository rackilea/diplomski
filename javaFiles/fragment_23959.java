public static <T> List<T> findEntity(Class<T> entityClass, boolean isEnabled) {
    CriteriaQuery<T> criteria = builder.createQuery(entityClass);
    Root<T> entityRoot = criteria.from(entityClass);
    criteria.select(entityRoot);

    criteria.where(builder.equal(
            entityRoot.get("enable"), //path expression
            builder.parameter(Boolean.class, "isEnabled")) //parameter expression
    );

    criteria.orderBy(order);
    return em.createQuery(criteria)
            .setParameter("isEnabled", isEnabled)
            .getResultList();
}