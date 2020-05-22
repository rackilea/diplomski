public boolean update(YourClass yourObject) {
    Transaction transaction = null;
    boolean result = false;
    try {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        transaction = session.beginTransaction();
        session.update(yourObject);
        transaction.commit();

        result = true;

    } catch (Exception ex) {
        ex.printStackTrace();
        if (transaction != null) {
            transaction.rollback();
        }
    }
    return result;
}
 public boolean update2(YourClass yourObject)  {
    Transaction transaction = null;
    int result = -1;
    try {
        String sqlQuery = "UPDATE YourTable SET yourColumn1=" + yourObject.value1
                + ", yourColumn2='" + yourObject.value2 + "' WHERE [some condition]=";
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        transaction = session.beginTransaction();
        SQLQuery query = session.createSQLQuery(sqlQuery);
        result = query.executeUpdate();
        transaction.commit();

    } catch (Exception ex) {
        ex.printStackTrace();
        if (transaction != null) {
            transaction.rollback();
        }
    }
    return result;
}