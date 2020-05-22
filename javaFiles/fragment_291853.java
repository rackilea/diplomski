public static <T> void queryResult(String query, Class<? extends T> clazz) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Query q = session.createSQLQuery(query).addEntity(clazz);
    List rows = q.list();
    Iterator it = rows.iterator();
    while (it.hasNext()) {
        T t = (T) it.next();
        // do your work on object t
    }
}