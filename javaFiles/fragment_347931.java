Criteria c = session.createCriteria(SomeClass.class).add(Restrictions.idEq(id));

if (parents) {
  c.setFetchMode("parents", FetchMode.EAGER);
}
if (historicalData) {
  c.createCriteria("collection", Criteria.LEFT_JOIN)
   .add(Restriction.lt("date", date))
   .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
}
return c.uniqueResult();