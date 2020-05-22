public static Specification<Person> hasAllAttributes(List<Long> attr) {

    return (root, query, cb) -> {

        Subquery<Long> subquery = query.subquery(Long.class);
        Root<Attribute> subRoot = subquery.from(Attribute.class);
        subquery.select(cb.count(subRoot));

        Predicate samePerson = cb.equal(root.get(Person_.ID), subRoot.get(Attribute_.PERSON));
        Predicate attributeInList = subRoot.get(Attribute_.ID).in(attr);

        subquery.where(cb.and(samePerson, attributeInList));

        return cb.equal(subquery, attr.size());
    };
}