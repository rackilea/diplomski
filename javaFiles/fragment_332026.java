public List<User> getAllUsers(User user) throws Exception {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria c = session.createCriteria(User.class).add(Restrictions.ne("idUser", user.getIdUser()));
            List<User> users = c.list();
            tx.commit();//i forget to add this

            return users;

        } catch (Exception e) {
            if (tx != null) tx.rollback(); throw e;

        } finally {
            session.close();
        }
    }