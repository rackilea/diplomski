@Controller
public class TestController {
    @RequestMapping(value="/test")
    public String showTestPage(HttpServletRequest request) {
        request.setAttribute("param1", "foo");
        request.setAttribute("param2", "bar");
        return "forward:/test2";
    }
}

@Controller
public class TestController2 {
    @RequestMapping(value="/test2")
    public String showTestPage(HttpServletRequest request) {
        String param1 = (String) request.getAttribute("param1");
        String param2 = (String) request.getAttribute("param2");
        return "testPageView";
    }
}