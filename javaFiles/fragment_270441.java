@Controller
public class HomeController {

    @RequestMapping("/login")
    public String login(Principal p) {
        //do something with your Principal if you want...
        return "login";
    }
}