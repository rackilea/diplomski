Criteria criteria = sess.createCriteria(Agency.class)
    for (Field f : Agency.class.getDeclaredFields())
    {
        if(f.isAccessible()) {
            criteria.add(Restrictions.like(f.getName(), "%big%"));
        }
    }
List agencies =   criteria.list();