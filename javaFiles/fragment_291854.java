public static <T> List<T> queryResult(String query, Class<? extends T> clazz) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Query q = session.createSQLQuery(query).addEntity(clazz);
    List<T> rows = (List<T>) q.list();
    return Collections.unmodifiableList(rows);
}

// now call generic method
List<User> users = queryResult("select * from User", User.class);
users.forEach(usr -> {
    System.out.println(usr.getEmail());
    System.out.println(usr.getName());
    System.out.println(usr.getIdUser());
    System.out.println(usr.getUser());
});