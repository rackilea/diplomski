public List<User> getUsers(int limit)
{
    Query q = getHibernateTemplate().getSession().createQuery("from User");
    q.setFirstResult(0); // modify this to adjust paging
    q.setMaxResults(limit);
    return (List<User>) q.list();
}