public User find(Long key) {
    // access on database 
    return (User) sessionFactory.getCurrentSession().get(User.class, key);
}

public List<User> list() {
    // again query the database for a list but not for a single user
    // the DAO is just something hibernate specific
    return userDAO.list();
}