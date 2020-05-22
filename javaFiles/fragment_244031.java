import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({ "v2/", "latest/" })
public class Version2Controller extends Version1Controller {

    @Override
    @ResponseBody
    @RequestMapping("bar")
    public String bar() {
        return "bar 2";
    }

}