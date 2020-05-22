@Repository("customerDao")
@Transactional
public class CustomerDaoImpl implements CustomerDao {

    @PersistenceContext
    private EntityManager em;

    public void addCustomer(Customer customer) {
        customer.setCreatedDate(new Date());
        em.persist(customer);
    }

    public List<Customer> findAllCustomer() {
        TypedQuery<Customer> query = em.createQuery("select c from Customer c", Customer.class);
        return query.getResultList();
    }
}