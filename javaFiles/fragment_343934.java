@RestController
public class HomeController {

    @RequestMapping("/")
    public String welcome() {
        return "login";
    }
}