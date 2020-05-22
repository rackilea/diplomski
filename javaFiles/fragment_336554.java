Criteria c = session.createCriteria(Product.class, "p")

DetachedCriteria sub = DetachedCriteria.forClass(Product.class, "p2");
sub.createAlias("p2.colors", "color");
sub.add(Restrictions.eqProperty("p2.id", "p.id"))
sub.add(Restrictions.in("color.color", new String[] {"RED", "GREEN"}));
sub.setProjection(Projections.count("color.id"));

c.add(Subqueries.eq(2, sub)); // or 2L