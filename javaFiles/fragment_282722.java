@Component
public class SaveJcrData implements SaveService {

 protected final Logger log = LoggerFactory.getLogger(this.getClass());

 @Reference
 private SlingRepository repository;

 @Reference
 private ResourceResolverFactory resolverFactory;

 private Session session;

 public void bindRepository(SlingRepository repository) {
  this.repository = repository;
 }

//Stores customer data in the Adobe CQ JCR
 public int injestData(String firstName, String lastName, String phone, String desc) throws Exception {

  Map<String, Object> param = new HashMap<String, Object>();
  param.put(ResourceResolverFactory.SUBSERVICE, "datawrite");
  ResourceResolver resolver = null;
        try {

   // Invoke the adaptTo method to create a Session used to create a QueryManager
   log.trace("In try.");
   resolver = resolverFactory.getServiceResourceResolver(param);                   
                   
   log.trace("resolveer created.");
   Session session = resolver.adaptTo(Session.class);
   log.info("Session created.");