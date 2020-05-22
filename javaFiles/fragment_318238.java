@Service
public class AnotherService {

    @Autowired
    @Qualifier("serviceA")
    private MyService myServiceWithBeanA;

    @Autowired
    @Qualifier("serviceB")
    private MyService myServiceWithBeanB;
}