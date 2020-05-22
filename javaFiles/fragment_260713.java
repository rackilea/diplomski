CriteriaBuilder cb = em.getCriteriaBuilder();

CriteriaQuery<Foo> cq = cb.createQuery(Foo.class);
Metamodel m = em.getMetamodel();
EntityType<Foo> Foo_ = m.entity(Foo.class);
Root<Foo> foo = cq.from(Foo_);
cq.where(my.get(Foo_.name).in(params));