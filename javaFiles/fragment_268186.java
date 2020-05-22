public List<YourEntity> findAllByKeywords(List<String> keywords){
    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    CriteriaQuery<YourEntity> query = builder.createQuery(YourEntity.class);
    Root<YourEntity> root = query.from(YourEntity.class);

    List<Predicate> predicates = new LinkedList<>();
    for (String keyword : keywords) {
        predicates.add(builder.like(root.<String>get("keywords"), "%" + keyword + "%"));
    }

    return entityManager.createQuery(
            query.select(root).where(
                    builder.or(
                            predicates.toArray(new Predicate[predicates.size()])
                    )
            ))
            .getResultList();
}