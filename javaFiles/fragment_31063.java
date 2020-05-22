EntityManager em = ... //However you get an em.
    try {
        em.getTransaction().begin();

        // ...  Put your persistence code here.

        em.getTransaction().commit();
    } catch (Exception ex) {
        em.getTransaction().rollback();
        throw ex;
    }finally {
        em.close();
    }