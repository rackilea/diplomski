ParentEntity parent = entityManager.find(ParentEntity.class, id);

// JPQL:
List<SingleSleeper> singleSleepers = entityManager.createQuery(
   "SELECT s FROM SingleSleeper s WHERE s.parent = %parent"
   ).setParameter("parent", parent).getResultList();

// Or Criteria API:
CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
CriteriaQuery<SingleSleeper> query = criteriaBuilder.createQuery(SingleSleeper.class);
Root<SingleSleeper> s = query.from(SingleSleeper.class);
query.select(s).where(criteriaBuilder.equal(s.get(SingleSleeper_.parent), parent));
List<SingleSleeper> singleSleepers = entityManager.createQuery(query).getResultList();