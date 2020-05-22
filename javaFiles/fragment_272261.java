@Stateless
public StatelessSessionBean implements StatelessSessionBeanLocal {

    @Inject
    private EntityManager em;

    @Override
    public Collection<MyObject> getAllObjects(){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriqQuery<MyObject> query = cb.createQuery(MyObject.class);
        query.from(MyObject);
        return em.createQuery(query).getResultList();
    }
}