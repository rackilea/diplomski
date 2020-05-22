@Controller
public class TestController {
    @RequestMapping(value="/test")
    public String showTestPage() {
        return "forward:/test2?param1=foo&param2=bar";
    }
}

@Controller
public class TestController2 {
    @RequestMapping(value="/test2")
    public String showTestPage(HttpServletRequest request) {
        String param1 = request.getParameter("param1");
        String param2 = request.getParameter("param2");
        return "testPageView";
    }
}