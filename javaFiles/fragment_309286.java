String sql = "select count(*) as result from table";
BigDecimal count = (BigDecimal) ht.execute(new HibernateCallback() {
    public Object doInHibernate(Session session)
            throws HibernateException {
        SQLQuery query = session.createSQLQuery(sql);
        // Add scalar to avoid bug in Hibernate query cache.
        query.addScalar("result", Hibernate.BIG_DECIMAL);
        return query.uniqueResult();
    }
});