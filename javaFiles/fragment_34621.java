@RestController
public class UserController {

// Here is where the injection takes place
@Autowired
private UserService userService;

  @RequestMapping("/users")
public List<User> getAllUsers(){
    return userService.getAllUsers();
}
@RequestMapping("/users/{id}")
public User getUser(@RequestParam int id) {
    return userService.getUser(id);
}
}