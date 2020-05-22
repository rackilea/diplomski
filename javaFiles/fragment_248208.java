List<Departement> departments = ...

List Employees = getHibernateTemplate().executeFind(new HibernateCallback<List>() {
    @Override
    public List doInHibernate(Session session) throws HibernateException, SQLException {
        Query query = session.createQuery(
                "select employee" +
                        "from employee e " +
                        "where e.department in (:departments) "
        );
        query.setParameterList("departments", departments);
        return query.list();
    }
});