protected Session getSession() {
    if (session == null) {
        session = sessionFactory.getCurrentSession();
    }

    return session;
}