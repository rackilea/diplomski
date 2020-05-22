DetachedCriteria dCriteria = DetachedCriteria.forClass(A.class)
          .add(Restrictions.eq("id", 1))
          .setProjection(Projections.property("id"));

Criteria criteria = session.createCriteria(B.class)
  .add(
    Restrictions.or(
      Restrictions.and(
        Subqueries.exists(dCriteria
                .add(Restrictions.eq("text", "a1")) // <-- Note extra restriction 
                .setProjection(Projections.property("text"))), // <-- and projection
        Restrictions.eq("idx", 1)
      ),
      Restrictions.and(
        Subqueries.notExists(dCriteria),
        Restrictions.eq("idx", 2)
      )
  ))
  .setProjection(Projections.property("id"));

Object o = criteria.list();