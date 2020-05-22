@Controller
@RequestMapping("/oauth")
public class OAuthController extends BaseController {

    @RequestMapping({"", "/"})
    public String home(HttpServletRequest req, Principal principal, Model model) {
        return "home"; // name of the template
    }
}