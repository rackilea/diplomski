@Repository
public class BusinessDetailsDAOImpl extends BaseDAOImpl<BusinessDetails, Long> implements BusinessDetailsDAO {

    @PersistenceContext
    protected EntityManager entityManager; 

    @Override
    public List<BusinessDetails> searchBusiness(BusinessSearchDTO businessSearchDTO, List<Long> businessIds) {

        // use directly entityManager instead of sessionFactory.getCurrentSession().getEntityManagerFactory().createEntityManager();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        // ...

}