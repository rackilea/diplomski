Session session = HibernateUtil.getSession();
    Criteria criteria = session.createCriteria(User.class);
    criteria.add(Restrictions.disjunction()
                    .add(Restrictions.eq("username", value))
                    .add(Restrictions.eq("email", value)));
    User user = (User)criteria.setMaxResults(1).uniqueResult();