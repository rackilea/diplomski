@Service
@Transactional
public class Bimpl implements B {

 @Autowired
 private MyRepository repository;

 private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void processEachCustomer(Customer customer){

    //process each customer - a new transaction everytime 
   //and it should be committed independently
   repository.updateCustomerData(customer.getId());
  }
}