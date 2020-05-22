Post post1 = new Post();
post1.setId(1L);
post1.setTitle(
    "The High-Performance Java Persistence book is to be released!"
);

entityManager.persist(post1);