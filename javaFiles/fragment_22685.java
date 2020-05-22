@Controller
@RequestMapping("/user/{username}")
public class UsersController {

  @Autowired
  HttpServletRequest req;

  @RequestMapping("/greet")
  public String greet() {
      return "Hello, " + username();
  }

  private String username() {
    Map<String, String> variables = (Map<String, String>)
      req.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
    return variables.get("username");
  }
}