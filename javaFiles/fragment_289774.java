import org.springframework.data.domain.Page;

public class UserController{

  @Autowired
  UserService userService;

  @RequestMapping(path = "/users", method = RequestMethod.GET)
  Page<User> getAll(HttpServletRequest request, UserSearchCriteria searchCriteria){
     return userService.findAllUsers(searchCriteria);
  }
}