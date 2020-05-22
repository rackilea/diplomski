Tuple tuple = entityManager
.createQuery(
    "select p.title as title, date_trunc(p.createdOn, :timezone) as creation_date " +
    "from Post p " +
    "where p.id = :postId", Tuple.class)
.setParameter("postId", 1L)
.setParameter("timezone", "UTC")
.getSingleResult();