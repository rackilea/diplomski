Criteria criteria  = session.createCriteria(LogEntries.class);

//select columns
ProjectionList columns = Projections.projectionList();
columns.add(Projections.property("timestamp"));
columns.add(Projections.property("log_level"));
criteria.setProjection(columns);

//conditions
Criterion timestamp = Restrictions.gt("timestamp", "2013-06-05 00:00:00");
Criterion originator = Restrictions.not(Restrictions.eq("originator", "com.me.myapp.SomeObject"));
LogicalExpression condition = Restrictions.and(timestamp, originator);

criteria.add(condition);
List results = criteria.list();