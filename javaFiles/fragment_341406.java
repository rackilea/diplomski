DetachedCriteria d = DetachedCriteria.forClass(QueryDetailEntity.class, "qd");
d.setProjection(Projections.projectionList().add(Projections.property("qd.query")));
d.add(Restrictions.or(Restrictions.like("qd.value1", "PROMPT%"), Restrictions.like("qd.value2", "PROMPT%")));

criteria = session.createCriteria(QueryEntity.class, "q");
criteria.add(Subqueries.propertyNotIn("q.primaryId", d));
criteria.list();