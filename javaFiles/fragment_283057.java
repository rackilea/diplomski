@Controller
public class UserController {

    @Autowired UserService userService;

    @RequestMapping("/users")
    public String home(Model model){
        List<User> listOfUsers = userService.findAll();
        UserWrapper userWrapper = new UserWrapper();
        userWrapper.setListOfUsers(listOfUsers);
        model.addAttribute("listOfUsers", listOfUsers);
        model.addAttribute("userWrapper", userWrapper);
        return "users";
    }

    @RequestMapping(value = "users", method = RequestMethod.POST)
    public String deleteUser(@ModelAttribute UserWrapper userWrapper, Model model){
        userService.deleteCheckedUser(userWrapper.getListOfUsers());
        return "redirect:/users";
    }
}