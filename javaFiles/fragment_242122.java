Map<String, Object> params = ...;
CriteriaBuilder cb = em.getCriteriaBuilder();           
CriteriaQuery<Tuple> cq = cb.createTupleQuery();     
Root<Transaction> r = cq.from(Transaction.class);

Predicate p= cb.conjunction();
for (Map.Entry<String, Object> param: params.entrySet())
    p = cb.and(p, cb.equal(r.get(param.getKey()), param.getValue()));

cq.multiselect(r.get("id"), r.get("status"), r.get("created_at"))
    .where(p)
    .orderBy(cb.asc(r.get("id")));

List<Tuple> result = em.createQuery(cq).getResultList();