CriteriaBuilder cb = em.getCriteriaBuilder();
CriteriaQuery<C> cq = cb.createQuery(C.class);
Root<C> c = cq.from(C.class);
Join<C, B> b = c.join("b");
cq.select(c)
cq.where(b.get("a").get("x").in(cb.parameter(List.class, "param")));

List<C> = em.createQuery(cq)
            .setParameter("param", Arrays.asList("foo", "bar", "baz"))
            .getResultList();