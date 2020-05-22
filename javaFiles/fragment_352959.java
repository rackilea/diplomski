Root<Foo> foo = cq.from(Foo.class);
Join<Foo, Bar> bar = foo.join(Foo_.bar);
ParameterExpression<Collection> bars = cb.parameter(Collection.class);
cq.where(bar.get(Bar_.id).in(bars));
TypedQuery<Foo> tq = em.createQuery(cq);
Collection<Integer> barsParameter = new ArrayList<Integer> ();
barsParameter.add(1);
List<Foo> resultList = tq.setParameter(bars, barsParameter).getResultList();