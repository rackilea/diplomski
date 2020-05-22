@Controller
public class TestController {
    @RequestMapping(value="/test")
    public String showTestPage() {
        return "forward:/test2";
    }
}

@Controller
public class TestController2 {
    @RequestMapping(value="/test2")
    public String showTestPage() {
        return "testPageView";
    }
}