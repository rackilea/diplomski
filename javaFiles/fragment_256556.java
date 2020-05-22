@Override
public void addUserRole(UserRole userRole) {
    Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
    String query = "insert into 'user_roles'('role','username') values(%s,%s)"; 
    Session session = this.sessionFactory.getCurrentSession();
    int resultCount = session.createSQLQuery(String.format(query, "'ROLE_USER'", "'acid'")).executeUpdate();

    tx.commit();
}