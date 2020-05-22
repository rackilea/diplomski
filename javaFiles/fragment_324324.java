Assembly newest = 
    (Assembly) session.createCriteria(Assembly.class)
    .add(Restrictions.eq("projectName", projectName))
    .addOrder(Order.desc("date"))
    .setMaxResults(1)
    .uniqueResult();