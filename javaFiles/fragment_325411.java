@Controller
public class RootController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root() {
        return "index";
    }
}