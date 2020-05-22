@ControllerAdvice
public class SomeControllerAdvice {
  @Autowired
  private MyCustomUserRepository myCustomUserRepository;

  @ModelAttribute
  public MyCustomUser getUser(Principal principal) {
     return myCustomUserRepository.findByUsername(principal.getName());
  }
}