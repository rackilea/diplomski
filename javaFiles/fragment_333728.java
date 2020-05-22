@RestController
public class VKAuthenticationController {
   @Autowired
   @Qualifier("myService")
   private AuthenticationService<VKToken> service;
}