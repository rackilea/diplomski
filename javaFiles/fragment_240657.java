@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/list/{field}", method = RequestMethod.GET)
    public String userList(Model model, @PathVariable("field") String field) {
        List<Users> userList = userDAO.searchAll();
        System.out.println("Condition "+field);
        model.addAttribute("userList", userList);
        return "user/list"; // added line. Alos return type to String
    }