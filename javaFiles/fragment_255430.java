@RestController
public class UserController {

    private JdbcUserDAO jdbcUserDAO;

    public JdbcUserDAO getJdbcUserDAO() {
        return jdbcUserDAO;
    }

    @Autowired
    public void setJdbcUserDAO(JdbcUserDAO jdbcUserDAO) {
        this.jdbcUserDAO = jdbcUserDAO;
    }

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