Criteria crit = getSession().createCriteria(Reportage.class);

DetachedCriteria dc = DetachedCriteria.forClass(Reportage.class);
dc.setProjection(Projections.max("version"));

crit.add(Property.forName("version").eq(dc));
return crit.list();