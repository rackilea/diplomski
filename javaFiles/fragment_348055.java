private EntityManager entityManager;

@Transactional
public findAll() {
  Query query = entityManager.createQuery("from myTable");
  return query.getResultList();
}