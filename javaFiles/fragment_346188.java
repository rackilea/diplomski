List<Post> posts = entityManager
.createQuery(
    "select p " +
    "from Post p " +
    "left join fetch p.comments " +
    "left join fetch p.tags " +
    "where p.id between :minId and :maxId", Post.class)
.setParameter("minId", 1L)
.setParameter("maxId", 50L)
.getResultList();