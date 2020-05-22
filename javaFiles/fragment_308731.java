import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Chris Harris
 *
 */
public class JPAResourceProducer {
@SuppressWarnings("unused")
@Produces
@PersistenceContext(unitName = "somePuName")
@SomeDatabase
private EntityManager em;
}