@SuppressWarnings("unchecked")
public List<Profession> getProfessionById(long id) throws Exception {
    session = sessionFactory.openSession();
    // Why would you need a transaction?
    // session.beginTransaction();
    String queryString = "SELECT p2 FROM Profession p1, Profession p2 WHERE p1.u_id=:id AND p2.profession=p1.profession";
    Query query = session.createQuery(queryString);
    query.setLong("id", id);

    return query.list();
}