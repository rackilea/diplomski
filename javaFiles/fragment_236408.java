@Component
@javax.jws.WebService (endpointInterface="com.test.IPSoap")
public class SOAPprocessImpl implements IPSoap {

     private static final Logger logger = Logger.getLogger(SOAPprocessImpl.class.getName());


     @Autowired //spring directly injects this object
     private IValidator validator;

     public IRResponse GetBalance(TSSearchParams SearchParams) {
        // Some processing logic
    }
}