@Configuration
@javax.jws.WebService (endpointInterface="com.test.IPSoap")
public class SOAPprocessImpl implements IPSoap, ApplicationContextAware {

   private static ApplicationContext context;

   private IValidator validator;

   public static ApplicationContext getApplicationContext() {
     return context;
   }

   @Override
   public void setApplicationContext(ApplicationContext ac)
      throws BeansException {
      SOAPprocessImpl.context = ac;
   }


   @PostConstruct//use PostConstruct
   public void init() {
     validator = (IValidator) context.getBean("IValidator");
   }


   //add your current code
}