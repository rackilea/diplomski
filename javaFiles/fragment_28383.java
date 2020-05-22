@Override   
public T findUniqueByQuery(String hsql, Map<String, Object> params) {
    Session session = sessionFactory.getCurrentSession();
    session.beginTransaction();
    Query query = session.createQuery(hsql);
    if (params != null) {
        for (String i : params.keySet()) {
            query.setParameter(i, params.get(i));
        }
    }
    return (T) query.uniqueResult();
}