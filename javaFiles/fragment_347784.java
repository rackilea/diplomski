final CriteriaBuilder builder = em.getCriteriaBuilder();
final CriteriaQuery<MyEntity> criteriaQuery = builder.createQuery(MyEntity.class);
final Root<MyEntity> myEntity= criteriaQuery.from(MyEntity.class);
final CriteriaQuery<MyEntity> select = criteriaQuery.multiselect(
                myEntity.get("zone"), versionTrack.get("school"));
select.distinct(true);