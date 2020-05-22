@Singleton
@Controller
@Autowire(mode = AutowireMode.BY_NAME)
@Path("/")
public class RootResource{

   private SomeService someService;

   private AnotherService anotherService;

   public void setSomeService(SomeService someService){
      this.someService = someService;
   }

   public void setAnotherService(AnotherService anotherService){
      this.anotherService = anotherService;
   }

 }