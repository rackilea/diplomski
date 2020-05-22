import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
@Stateless
public class StateInfo {
    @Inject
    @SomeDatabase
    private EntityManager em;