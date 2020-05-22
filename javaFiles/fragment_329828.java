final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<BigInteger> primaryIDQuery = builder.createQuery(BigInteger.class);
        final Root<MyData> data = primaryIDQuery.from(MyData.class);
        primaryIDQuery.select(data.<BigInteger> get("primaryId"));
        final Predicate primaryIDPredicate = builder.equal(profile.<BigInteger> get("primaryId"),1000);
        final Predicate otherPredicate = builder.or(
                builder.isTrue(profile.<Boolean> get("fieldA")),
                builder.isTrue(profile.<Boolean> get("fieldB")));
        primaryIDQuery.where(primaryIDPredicate , otherPredicate);

        final TypedQuery<BigInteger> existenceQuery = entityManager.createQuery(primaryIDQuery);

        boolean whatIWant = existenceQuery.getResultList().size() > 0;