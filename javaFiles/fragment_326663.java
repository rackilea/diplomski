@Stateless
public class JPAInvoiceDAO implements InvoiceDAO {

     @PersistenceContext
     private EntityManager entityManager;

     public Invoice getById(Long invoiceId) {
           return entityManager.find(invoiceId, Invoice.class);
     }

     // More DAO methods
}