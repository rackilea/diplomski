import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("v1/")
public class Version1Controller {

    @ResponseBody
    @RequestMapping("foo")
    public String foo() {
        return "Foo 1";
    }

    @ResponseBody
    @RequestMapping("bar")
    public String bar() {
        return "bar 1";
    }
}