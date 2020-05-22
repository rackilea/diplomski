@Service
    public class Aimpl implements A {

    @Autowired
    private B b;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

      public void methodA(List<Customer> customers){
       customers.forEach(customer -> {
         b.processEachCustomer(customer);
         });
      }
    }