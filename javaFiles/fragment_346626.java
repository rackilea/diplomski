@Controller
public class MainController extends BaseController  {

    @Secured("ROLE_ADMIN")
    @RequestMapping("/")
    String home(Model model) {
        return "home";
    }