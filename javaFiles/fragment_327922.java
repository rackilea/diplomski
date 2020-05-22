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
    public String showTestPage(@ModelAttribute DummyBinder params) {
        String param1 = params.getParam1();
        String param2 = params.getParam2();
        return "testPageView";
    }
}

class DummyBinder {
    private String param1;
    private String param2;

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        this.param2 = param2;
    }
}