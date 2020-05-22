@Override
public List<Distribution> getListOrderByCount(String userName) {
    List<Distribution> result = (List<Distribution>) sessionFactory
            .getCurrentSession()
            .createQuery(
      "from Distribution as d where d.username=:userName ORDER BY d.count DESC")
            .setString("userName", userName).list();
    return result;
}