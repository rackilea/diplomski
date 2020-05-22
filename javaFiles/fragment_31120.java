EntityManager entityManager = entityManagerFactory.createEntityManager();

...

entityManager.getTransaction().begin();
entityManager.persist(a);
entityManager.persist(b);
entityManager.getTransaction().commit();