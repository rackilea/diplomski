@RestController  
@RequestMapping("users")  
public class UsersController {

  private UserRepository userRepository;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }  

  /**
   * In list method we only want users default values to keep the payload smaller.
   */
  @GetMapping("list")
  @JsonView(UserSerializer.User.class)  
  public @ResponseBody ArrayList<User> list() {
    ArrayList<User> users = new ArrayList<>();

    for (User user : userRepository.findAll()) {
      users.add(user);
    }

    return users;
  }


  /**
   * In this method we are only fetching a single user so payload is smaller so we can add the users posts as well. You could also toggle this with a url filter/parameter.  
   */
  @GetMapping("show")
  @JsonView(UserSerializer.UserWithPosts.class)  
  public @ResponseBody ArrayList<User> show(@RequestParam(name = "id", required = true) Long id) {
    return userRepository.findOne(id):
  }

}