Criteria crit = session.createCriteria(House.class);
crit.add(Expression.ge("size", 20));
crit.setMaxResults(10);
crit.addOrder(Order.desc("size"));
crit.setFetchMode("resident", FetchMode.JOIN);
crit.setProjection(Projections.property("resident"));
return crit.list();