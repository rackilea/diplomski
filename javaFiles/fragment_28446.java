@SuppressWarnings("unchecked")
public List<User> getUsersWithSameProfessionsById(long id) throws Exception {
    session = sessionFactory.openSession();
    String queryString = "SELECT DISTINCT u FROM Profession p1, Profession p2 JOIN p2.user u WHERE p1.u_id=:id AND p2.profession=p1.profession";
    Query query = session.createQuery(queryString);
    query.setLong("id", id);

    return query.list();
}