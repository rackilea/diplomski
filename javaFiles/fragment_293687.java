Post post1 = entityManager.find(Post.class, 1L);
post1.setTitle(post1.getTitle().replace("to be ", ""));

Post post2 = new Post();
post2.setId(2L);
post2.setTitle(
    "The High-Performance Java Persistence book is awesome!"
);

entityManager.persist(post2);