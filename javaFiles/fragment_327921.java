@Controller
public class TestController2 {
    @RequestMapping(value="/test2")
    public String showTestPage(@RequestParam String param1, @RequestParam String param2) {
        return "testPageView";
    }
}