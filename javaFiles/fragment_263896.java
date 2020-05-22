session.createCriteria(EUser.class)
   .add(Restrictions.disjunction()
      .add(Restrictions.like("userName", "mat%"))
      .add(Restrictions.like("firstName", "mat%")) 
      .add(Restrictions.like("lastName", "mat%")) 
      .add(Restrictions.like("middleName", "mat%")))
   .add(Restrictions.eq("enable ", "active"))
   .list();