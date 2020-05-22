public static Session getHibernateSession() {

    final SessionFactory sf = new Configuration()
        .configure("yourConfig.cfg.xml").buildSessionFactory();

    // factory = new Configuration().configure().buildSessionFactory();
    final Session session = sf.openSession();
    return session;
    }