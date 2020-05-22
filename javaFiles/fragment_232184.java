@Controller
public class HomeController {

    @RequestMapping("/welcome")
    public String welcome() {
        return "main-menu";
    }
}