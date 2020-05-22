CriteriaBuilder builder = entityManager.getCriteriaBuilder();
CriteriaQuery<Foo> criteria = builder.createQuery(Foo.class);
Root<Foo> fromFoo = criteria.from(Foo.class);
Join<Foo, Bar> foobars = (Join) fromFoo.fetch("bars");

List<Predicate> conditions = new ArrayList<>();
conditions.add(builder.equal(fromFoo.get("deleted"), 0));
conditions.add(builder.equal(foobars.get("deleted"), 0));

TypedQuery<Foo> typedQuery = entityManager.createQuery(
        criteria.select(fromFoo)
                .where(conditions.toArray(new Predicate[]{})));