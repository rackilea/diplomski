@Service
public class BasicTransactionalService {
  @PersistenceContext
  HibernateEntityManager em;

  @Transactional
  public void testFlushInTransactional() {
    em.flush();
  }

  @Deprecated
  public void testFlushOutsideTransactional() {
    em.flush();
  }

  @Transactional
  public void testFlushSubroutineTransactional() {
    testFlushOutsideTransactional();
  }
}