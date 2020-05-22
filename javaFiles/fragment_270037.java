EntityManager em = emf.createEntityManager();
em.getTransaction().begin();
EntityManager em2 = emf.createEntityManager();
em2.getTransaction().begin();
getDatabaseSessionId(System.out, em);
getDatabaseSessionId(System.out, em2);
em.close();
em2.close();
emf.close();