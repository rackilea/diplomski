@Controller
public class HomeController {
    @RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, path = "/")
    public String home() {
        return "redirect:" + RequestMappings.UI;
    }
}