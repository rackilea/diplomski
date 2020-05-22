public class ClassName {

    @PersistenceContext(unitName = "myPU")
    public EntityManager em;

    @Resource
    UserTransaction utx;