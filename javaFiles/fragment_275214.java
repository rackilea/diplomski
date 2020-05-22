Criteria stateCriteria = session.createCriteria(State.class);
Criteria countryCriteria = stateCriteria.createCriteria("country");
stateCriteria.addOrder(Order.desc("stateName"));
stateCriteria.setFirstResult(pagesize * pagenum);
stateCriteria.setMaxResults(pagesize);
List results = stateCriteria.list();