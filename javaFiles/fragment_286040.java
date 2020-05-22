@Stateless
public class MyService {
    @PersistenceContext(unitName="user-unit") 
    private EntityManager em;

    public void create(User newUser) {
        em.persist(newUser);
    }
}