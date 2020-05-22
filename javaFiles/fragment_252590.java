DetachedCriteria colorCrit = DetachedCriteria.For(Product.class)
    .createAlias("colors","color")
    .add(Restriction.eq("color.color", "RED")
    .add(Restriction.eq("color.color", "GREEN")
    .SetProjection(new GroupByHavingProjection("id", Projections.count("id"), "=", 2));

Criteria criteria = createCriteria()
    .add(Subqueries.in("id", colorCrit)
    .list();