return getHibernateTemplate().executeFind(new HibernateCallback() {
        public Object doInHibernate(Session session) throws HibernateException, SQLException {
            Query q = session.createQuery("from User");
            q.setMaxResults(limit);
            return q.list();
        }
    });