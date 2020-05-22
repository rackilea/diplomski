@Service
public class ForgetService{
   @Bean("GetTokenService")
   public CompletableFuture<Object> getTokenService() {
       Map<String, Object> map = new HashMap<>(8);
       map.put("status", ErrorEnum.TOKEN_SUSSCESS.getStatus());
       map.put("message", ErrorEnum.TOKEN_SUSSCESS.getMessage());
       return CompletableFuture.completedFuture(map); 
   }
@RestController
public class ForgetController {
   private final ForgetService forgetService;
   @Autowired
   private ForgetController(ForgetService forgetService) {
       this.forgetService = forgetService;
   }
   @PostMapping(value = "/forget/token")
   @Async("GetTokenService")
   public CompletableFuture<Object> getTokenController() {
       return CompletableFuture.completedFuture(forgetService.getTokenService());
}