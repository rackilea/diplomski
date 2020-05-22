Map<SingularAttribute<Transaction, ?>, Object> params = ...;
CriteriaBuilder cb = em.getCriteriaBuilder();           
CriteriaQuery<Tuple> cq = cb.createTupleQuery();     
Root<Transaction> r = cq.from(Transaction.class);

Predicate p= cb.conjunction();
for (Map.Entry<SingularAttribute<Transaction, ?>, Object> param: params.entrySet())
    p = cb.and(p, cb.equal(r.get(param.getKey()), param.getValue()));

cq.multiselect(r.get(Transaction_.id), r.get(Transaction_.status), 
          r.get(Transaction_.created_at))
    .where(p)
    .orderBy(cb.asc(r.get(Transaction_.id)));

List<Tuple> result = em.createQuery(cq).getResultList();