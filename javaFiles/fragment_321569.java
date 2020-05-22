protected List<T> findByCriteria(Session session, Criterion... criterion) {
    Criteria crit = session.createCriteria(getPersistentClass());
    for (Criterion c : criterion) {
        crit.add(c);
    }
    crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    return crit.list();
}