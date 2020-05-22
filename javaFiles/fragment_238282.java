@Component
public class AsyncUserService {

  @Async("customTaskExecutor")
  public void updateOrAddUser(int id, HttpServletRequest request) throws {
    //do your stuff
  }
}

@Controller
@RequestMapping("/users")
public class UserController {
  private final AsyncUserService userService;

  @Autowired
  public UserController(AsyncUserService userService) {
    super();
    this.userService = userService;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  @ResponseStatus(HttpStatus.OK)
  public void putUser(@PathVariable("id") int identifier, HttpServletRequest request) {
    userService.updateOrAddUser(identifier, request);
  }
}