import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Stateless
public class AService{

    // @PersistenceContext properly filled
    private EntityManager em;

    public List<A> fetchAEntities(){
        TypedQuery<A> query = em.createNamedQuery("A.findAllByCategoryId", A.class);
        // it seems you can afford hardcoding it
        query.setParameter("categoryId", 1);

        return query.getResultLis();
    }
}