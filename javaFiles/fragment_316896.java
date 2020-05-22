Tuple tuple = entityManager
.createQuery(
    "select p.title as title, date_trunc(p.createdOn) as creation_date " +
    "from Post p " +
    "where p.id = :postId", Tuple.class)
.setParameter("postId", 1L)
.getSingleResult();

assertEquals(
    "High-Performance Java Persistence", 
    tuple.get("title")
);

assertEquals(
    Timestamp.valueOf(
        LocalDateTime.of(2018, 11, 23, 0, 0, 0)
    ), 
    tuple.get("creation_date")
);