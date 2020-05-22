@Autowired
EntityManager em;

private List<User> findByLikeIn(String columnName, List<String> values) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<User> cq = cb.createQuery(User.class);
    Root<User> users = cq.from(User.class);

    values.stream()
        .map(v -> cb.like(users.get(columnName), "%" + v + "%"))
        .reduce(cb::or)
        .ifPresent(cq::where);

    TypedQuery<User> query = em.createQuery(cq);
    return query.getResultList();
}