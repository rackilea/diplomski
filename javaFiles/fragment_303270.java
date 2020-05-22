@PersistenceContext
EntityManager em;

List<YourEntity> method(String argument) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<YourEntity> cq = cb.createQuery(YourEntity.class);
    Root<YourEntity> root = cq.from(YourEntity.class);

    List<Predicate> predicates = new ArrayList<>();
    if (argument == null) {
        predicates.add(cb.equal(root.get("yourAttribute"), argument);
    }
    // rest of your logic goes here

    cq.where(predicates.toArray(new Predicate[]{}));
    return em.createQuery(cq).getResultList();
}