doInJPA(entityManager -> {
    entityManager.persist(new Post());
    entityManager.persist(new Post("ABC"));
    entityManager.persist(new Post());
    entityManager.persist(new Post("DEF"));
});