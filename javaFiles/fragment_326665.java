@ManagedBean
public class InvoiceBacking {

     private Long invoiceId; // + getter/setter
     private Invoice invoice; // + getter

     @EJB
     private InvoiceDAO invoiceDAO;

     @PostConstruct
     public void init() {
          invoice = invoiceDAO.getById(invoiceId);
     }
 }