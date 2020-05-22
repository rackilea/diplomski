public List<DocumentsShort> findAllByCriteria(Integer firstResult, Integer maxResult, String sort, String condition, List<Map<String, Object>> conditions) {
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<EntityClass> criteriaQuery = cb.createQuery(EntityClass.class);
    Root<EntityClass> root = criteriaQuery.from(EntityClass.class);
    Join<EntityClass, AnotherEntityClass> AnotherEntityClassJoin = root.join("fieldOfEntity", JoinType.LEFT);
    Predicate predicate = cb.conjunction();
    List<Predicate> predicateList = new ArrayList<>();
    for (Map<String, Object> map : conditions) {
        Predicate tempPredicate = cb.conjunction();
        tempPredicate = cb.and(predicate, cb.equal(root.get("deleted"), 0)); // only entities not marked as deleted
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Path pathToField = null;
            pathToField = root.get(key);
            Object value = entry.getValue();
            if (value == null) {
                tempPredicate = cb.and(tempPredicate, cb.isNull(pathToField));
            } else if (value instanceof String) {
                tempPredicate = cb.and(tempPredicate, cb.like(pathToField, "%" + value + "%"));
            } else if (value instanceof List) {
                tempPredicate = cb.and(tempPredicate, pathToField.in(((List) value)));
            } else {
                tempPredicate = cb.and(tempPredicate, cb.equal(pathToField, value));
            }
        }
        predicateList.add(tempPredicate);
    }
    criteriaQuery.where(cb.or(predicateList.toArray(new Predicate[predicateList.size()])));
    TypedQuery query = entityManager.createQuery(criteriaQuery);
    query.setFirstResult(firstResult != null ? firstResult : 0);
    query.setMaxResults(maxResult != null ? maxResult : 500);

    return query.getResultList();
}