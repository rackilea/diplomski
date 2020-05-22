CriteriaBuilder qb = entityManager.getCriteriaBuilder();
CriteriaQuery<Long> cq = qb.createQuery(Long.class);
cq.select(qb.count(cq.from(MyEntity.class)));
ParameterExpression<Integer> p = qb.parameter(Integer.class);
q.where(qb.eq(c.get("age"), 45));
return entityManager.createQuery(cq).getSingleResult();