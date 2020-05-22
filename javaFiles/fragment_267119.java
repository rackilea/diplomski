CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
Root tableA = cq.from(TableA.class);

Subquery<String> sq = cq.subquery(TableB.class);
Root tableB = cq.from(TableB.class);
sq.select(tableB.get("d"));
sq.where(cb.equal(tableB.get("id"), 3));

cq.multiselect(
    cb.get("a"),
    cb.get("b"),
    cb.get("c"));
cq.where(cb.equal(tableA.get("a"), sq));
List<Object[]> = em.createQuery(cq).getResultList();