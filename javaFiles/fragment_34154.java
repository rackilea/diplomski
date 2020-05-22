@PersistenceContext
private EntityManager em;

@Transactional
public void save(Object obj) {
    em.persist(obj);
}