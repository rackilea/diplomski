@RestController
public class DemoRestController {
   @Autowired
   VptService vptService;

   @ConfigItem(key="KS001")
   private PrgmParm prgmKs001;

   @ConfigItem(key="KS002")
   private PrgmParm prgmKs002;

   public DemoRestController() {
     super();
   }