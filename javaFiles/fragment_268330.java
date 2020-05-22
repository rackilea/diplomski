// This is the subquery
DetachedCriteria subquery = DetachedCriteria.forClass(Rate.class)
    .add(Restrictions.eq("user_id", 55))
    .setProjection(Projections.id())

// This corresponds to (SELECT * FROM Unit WHERE id not in (subquery))
Criteria criteria = session
    .createCriteria(Unit.class)
    .add(Subqueries.notIn("id", subquery));