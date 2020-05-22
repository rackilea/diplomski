Criterion restriction = yourRestrictions;
Object result = null;  // will later contain a random entity
Criteria crit = session.createCriteria(Picture.class);
crit.add(restriction);
crit.setProjection(Projections.rowCount());
int count = ((Number) crit.uniqueResult()).intValue();
if (0 != count) {
  int index = new Random().nextInt(count);
  crit = session.createCriteria(Picture.class);
  crit.add(restriction);
  result = crit.setFirstResult(index).setMaxResults(1).uniqueResult();
}