@Controller
public class MyController {

    @RequestMapping("/myurl")
    public String redirectWithUsingForwardPrefix(ModelMap model) {
        model.addAttribute("attribute", "forwardWithForwardPrefix");
        return "forward:/http://localhost:9090/myproject/payreq";
    }
}