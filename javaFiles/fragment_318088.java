CriteriaBuilder builder = entityManager.getCriteriaBuilder();
CriteriaQuery<Person> criteria = builder.createCriteria(Person.class);
Root<Person> pRoot = criteria.from(Person.class);
Join<Person, Language> langJoin = criteria.join("language", JoinType.LEFT);

Predicate conjunction = builder.conjunction();

criteria.where(builder.and(
    builder.like(langJoin.get(Language_.locale), locale),
    builder.like(pRoot.get(Person_.name), name),
    builder.between(pRoot.get(Person_.time), startDate, endDate));

criteria.orderBy(builder.asc(pRoot.get(Person_.name)));