@RestController
@Scope("session")
public class Controller {

    @Autowired
    private SessionDetails details;

    @PostMapping(path = "/validate")
    public void validate() {
        details.setUserDetails(...);
    }

    @GetMapping(path = "/apply")
    public String apply() {
        final UserDetailTO userDetails = details.getUserDetails();
        ...
    }

}

@Component
@Scope("session")
class SessionDetails {
    private String message;
    private UserDetailTO userDetails;
    // getters & setters
}