@Repository
public class SomeEntityRepository {
  private SessionFactory sessionFactory;

  // Constructor-injection injects a SessionFactory
  @Autowired
  public SomeEntityRepository(SessionFactory sessionFactory) {
    this.sesssionFactory = sessionFactory;
  }

  // uses SessionFactory to get the current session, iterates the collection
  // and calls saveOrUpdate on each instance inside the collection.
  public void saveOrUpdateAll(Collection<?> collection) {
    Session session = sessionFactory.getCurrentSession();
    for(Object object : collection) {
      session.saveOrUpdate(object);
    }       
  }
}