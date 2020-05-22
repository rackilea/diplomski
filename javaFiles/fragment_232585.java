import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/show")
public class HelloController {

    @RequestMapping(value = { "/{string:.+}" })
    public String handleReqShow(@PathVariable String string,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String family, Model model) {
        System.out.println(string);
        model.addAttribute("message", "I am called!");
        return "hello";
    }

    @RequestMapping(value = { "/{string:.+}", "/{string:.+}/{mystring:.+}" })
    public String whatever(@PathVariable String string,
            @PathVariable String mystring,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String family, Model model) {
        System.out.println(string);
        System.out.println(mystring);
        model.addAttribute("message", "I am called!");
        return "hello";
    }
}