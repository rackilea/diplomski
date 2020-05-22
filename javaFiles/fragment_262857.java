@Controller
public class MyHelloWorldController {

    @RequestMapping("/helloWorld", params = { "type=42" })
    public String helloWorld(Model model) {
        model.addAttribute("message", "Hello World from my new controller");
        return "helloWorld";
    }

}