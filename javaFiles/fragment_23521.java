...
        EntityManager em = factory.createEntityManager();
        Query query;

        em.getTransaction().begin();
        query = em.createNativeQuery("ALTER SESSION SET CURRENT_SCHEMA="+schemaName);
        query.executeUpdate();
        em.getTransaction().commit();