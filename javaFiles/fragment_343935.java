@Controller
public class HomeController {

    @RequestMapping("/")
    @ResponseBody
    public String welcome() {
        return "login";
    }
}