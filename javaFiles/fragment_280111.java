@Controller
public class UserController {

@Autowired //this will give you the reference to UserDAO      
UserDAO userDao; 
  // UserController methods ...

  @RequestMapping(value="/{user}")
  public String create(String user) {

    // Here I want to use the UserDAO
    userDao.userDaoMethod();
    // ...

  }

}