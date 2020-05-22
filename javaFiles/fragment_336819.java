public void saveOrUpdateAll(final Collection entities) throws DataAccessException {
    executeWithNativeSession(new HibernateCallback() {
        public Object doInHibernate(Session session) throws HibernateException {
            checkWriteOperationAllowed(session);
            for (Iterator it = entities.iterator(); it.hasNext(); ) {
                session.saveOrUpdate(it.next());
            }
            return null;
        }
    });
}