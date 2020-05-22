Post post = new Post();
post.setId(1L);
post.setTitle(
    "High-Performance Java Persistence"
);
post.setCreatedOn(
    Timestamp.valueOf(
        LocalDateTime.of(2018, 11, 23, 11, 22, 33)
    )
);

entityManager.persist(post);