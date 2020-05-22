@Override
public List<User> list() {
    Session session  = this.sessionFactory.openSession();
    List<User> users = session.createQuery("select u from User u").list();
    session.close();
    return users;
}