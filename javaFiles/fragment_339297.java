final CriteriaBuilder criteriaBuilder = entityManagerFactory.getCriteriaBuilder();
CriteriaQuery<Long> criteria = qb.createQuery(Long.class);
Root<Country> root = criteria.from(Rating.class);
criteria.select(criteriaBuilder.count(root));

ParameterExpression<Job> param = criteriaBuilder.parameter(Job.class);
criteria.where(criteriaBuilder.equal(root.get("job"), param));