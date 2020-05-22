public List<YourEntity> findAllByKeywords(List<String> keywords){
    final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    CriteriaQuery<YourEntity> query = builder.createQuery(YourEntity.class);
    final Root<YourEntity> root = query.from(YourEntity.class);
    return entityManager.createQuery(
            query.select(root).where(
                    builder.or(
                            transform(keywords, toPredicateFunction(builder, root)).toArray(new Predicate[]{})
                    )
            ))
            .getResultList();
}

private Function<String, Predicate> toPredicateFunction(final CriteriaBuilder builder, final Root<YourEntity> root) {
    return new Function<String, Predicate>() {
        @Override
        public Predicate apply(String input) {
            return builder.like(root.<String>get("keywords"), "%" + input + "%");
        }
    };
}