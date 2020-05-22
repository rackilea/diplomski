@RestController
public class UserController {

    @Autowired
    private JdbcUserDAO jdbcUserDAO;

    @RequestMapping("/")
    @ResponseBody
    public String welcome() {
        return "Welcome to RestTemplate Example.";
    }

    @RequestMapping(value="/users", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody   
    public List<User> getAllUsers() {
        System.out.println("jdbcUserDAO"+jdbcUserDAO);
        List<User> userList = jdbcUserDAO.getAllUsers();
        System.out.println(userList);
        return userList;
    }

}