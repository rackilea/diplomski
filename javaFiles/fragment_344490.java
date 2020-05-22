@PersistenceContext
private EntityManager entityManager;

@Transactional
public void storeList(List<MyEntity> entities) {
  int imported = 0;
  for (MyEntity e: entities) {
    entityManager.persist(e);
    if (++imported % 50 == 0) {
      entityManager.flush();
      entityManager.clear();
    }
  }
}