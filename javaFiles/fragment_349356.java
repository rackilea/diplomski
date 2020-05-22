public List<UserH> getAllUsers() {

    EntityManager entityManager = HibernateUtils.getEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    transaction.begin();
    TypedQuery<UserH> usersQuery = entityManager.createQuery("from UserH ", UserH.class);
    List<UserH> usersList = usersQuery.getResultList();
    transaction.commit();
    entityManager.close();

    return usersList;
}