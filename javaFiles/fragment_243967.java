@Stateless
public class BaseService {

    @PersistenceContext
    private EntityManager em;

    public BaseEntity<? extends Number> find(Class<BaseEntity<? extends Number>> type, Number id) {
        return em.find(type, id);
    }

}