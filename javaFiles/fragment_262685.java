public static final String USER_NAME = "userName";

private List<User> findByProperty(String propertyName, Object value) {
    log.debug("finding User instance with property: " + propertyName    + ", value: " + value);
    try {
        String queryString = "from User as model where model." + propertyName   + "= ?";
        Query queryObject = getSession().createQuery(queryString);
        queryObject.setParameter(0, value);
        return queryObject.list();
    } catch (RuntimeException re) {
        log.error("find by property name failed", re);
        throw re;
    }
}

public List<User> findByUserName(Object userName) {
    return findByProperty(USER_NAME, userName);
}

@Override
public void deleteUsers(String userName) {
  try {
    List<User> list = findByUserName(userName);
    for (User user: list)
      getSession().delete(user);
    log.debug("delete successful");
  } catch (RuntimeException re) {
    log.error("delete failed", re);
    throw re;
  }
}