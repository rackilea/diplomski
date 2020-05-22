@Dependent
public class FooDAO {

    @PersistenceContext
    private EntityManager em;

    public FooEntity find(final Number id) throws NoResultException {
        return em.find(FooEntity.class, id);
    }

    public List<FooEntity> findAll() {
        return em.createNamedQuery("FooEntity.findAll", FooEntity.class).getResultList();
    }

    // ...
}