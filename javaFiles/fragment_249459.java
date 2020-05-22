public static <T> T read(Integer id, Class<T> clazz) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    T object = (T) session.get(clazz, id);
    session.close();
    return object;
}