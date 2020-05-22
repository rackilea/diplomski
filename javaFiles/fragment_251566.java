CriteriaBuilder builder = em.getCriteriaBuilder();
Predicate conjunction = builder.conjunction();
if (var1 != null) {
    conjunction = builder.and(conjunction,
                              builder.equal(root.get(MyEntity_.var1),
                                            var1));
}
if (var2 != null) {
    conjunction = builder.and(conjunction,
                              builder.equal(root.get(MyEntity_.var2),
                                            var2));
}
...
criteria.where(conjunction);