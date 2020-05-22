DetachedCriteria innerQuery = DetachedCriteria.forClass(Member.ENTITY_NAME, "inner");
  innerQuery.setProjection(Projections.rowCount());
  innerQuery.add(Restrictions.eqProperty("lastName", "outer.lastName"));

  Criteria c = s.createCriteria(Member.ENTITY_NAME, "outer");
  c.setProjection(Projections.property("lastName"));
  c.add(Restrictions.gt("endDate", now))   
  c.add(Subqueries.eq(new Integer(1), innerQuery));