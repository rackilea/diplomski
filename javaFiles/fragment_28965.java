@Controller
@RequestMapping(value = "/foo")
public class AdminController {

    @RequestMapping(value = "/bar")
    public String testAction(@RequestParam String fieldName) {
        // yourValue contain the value post from the html form
        return "yourview";
    }
}