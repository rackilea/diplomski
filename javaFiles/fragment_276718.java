Controller
    public class HelloWorldController {
        @RequestMapping("/")
        public String sayHello(ModelMap model) {
            model.addAttribute("greeting", "Hello World from Spring 4 MVC");
            return "welcome";
        }
    }