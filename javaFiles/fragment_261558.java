@Stateless
@TransactionAttribute(value = TransactionAttributeType.REQUIRES_NEW)
class B implements A {
    private EntityManager entityManager;  

    @PersistenceContext(unitName = "Draco-PU", type = PersistenceContextType.TRANSACTION)
    public void setEntityManager(EntityManager em) {
        entityManager = em;
    }

    @PostConstruct
    public init() {
        //body of init method
    }
}