@PersistenceContext
private EntityManager entityManager;

public List<Car> findAllCars() {
  String jpql = "select c from Car c";
  Query query = entityManager.createQuery(jpql);
  return query.getResultList();
}