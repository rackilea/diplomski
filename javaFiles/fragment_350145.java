@Repository
public class CustomerDao {

    @PersistenceContext
    private EntityManager em;

    public void saveCustomer(Customer customer) {
        em.persist(customer);
    }
}