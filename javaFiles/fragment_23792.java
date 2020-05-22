@Controller
public class UserController {

    @RequestMapping(value = "/showUsers", method = RequestMethod.GET)
    public String showUserInfo(Model model) {
        // here you prepare the userList, the list of Users along with information
        // here User can be fetched from DB & values stored in User DTO and then DTO in the list
        List<User> userNameList = new ArrayList<User>();
        userNameList.add(User DTO objects go here);
        model.addAttribute("userNameList", userNameList);
        return "userlist";       // remember this is our jsp name
    }
}