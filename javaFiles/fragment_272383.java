@Controller
@RequestMapping("/welcome.htm")
@SessionAttributes({"user"})
public class WelcomeController {
    @RequestMapping(method = RequestMethod.POST)
    public String processSubmit(ModelMap modelMap){
       User user = loginService.loginUser(loginCredentials);
       modelMap.addtAttribute(user);
       return "loginSuccess";
    }
}