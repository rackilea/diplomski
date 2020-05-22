CriteriaBuilder cb = em.getCriteriaBuilder();
CriteriaQuery<Long> q = cb.createQuery(Long.class);
Root<A> r = q.from(A.class);
MapJoin<A, String, String> m = r.joinMap("metadata");
q.select(cb.count(r)).where(cb.equal(m.key(), "A"));
Long rs = em.createQuery(q).getSingleResult();