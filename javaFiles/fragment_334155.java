Session session = (Session)this.em.getDelegate();
Criteria crit = session.createCriteria(getEntityClass());
crit = crit.createAlias("contractDetail", "cd", JoinType.LEFT_OUTER_JOIN);
crit = crit.createAlias("cd.contract", "c", JoinType.LEFT_OUTER_JOIN);

Criterion criterion= Restrictions.eq("c.operator", operator);

crit.add(c);

List result = crit.list();