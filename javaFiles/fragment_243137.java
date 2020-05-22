CriteriaBuilder cb = em.getCriteriaBuilder();
CriteriaQuery<Tuple> cq= cb.createTupleQuery();

Root<Documents> root = cq.from(Documents.class);
Expression<Integer> userId = root.get("USERID");
Expression<String> userType = root.get("USERTYPE");
Expression<Long> count = cb.count(userId);

cq.multiselect(userId.alias("USERID"), count.alias("CNT"));
cq.where(cb.equal(userType, "COMPANY");
cq.groupBy(userId);
cq.orderBy(cb.desc(count));

TypedQuery<Tuple> tq = em.createQuery(cq);
for (Tuple t : tq.getResultsList()) {
  System.out.println(t.get("USERID"));
  System.out.println(t.get("CNT"));
}