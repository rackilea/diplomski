DetachedCriteria dc = DetachedCriteria.forClass(A.class);
Criteria c1 = dc.getExecutableCriteria(session);
c1.setProjection(Projections.rowCount());
long count = ((Number) c1.uniqueResult()).longValue();
System.out.println(count + " result(s) found:");

Criteria c2 = dc.getExecutableCriteria(session);
System.out.println(c2.list());