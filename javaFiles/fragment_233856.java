Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
    try {
        tx = session.beginTransaction();
        // save/ update / delete your entities here
        tx.commit();
    } catch (RuntimeException ex) {
        if (tx != null) {
            tx.rollback();
        }
        throw ex;
    } finally {
        session.close();
    }