@Controller
//@RequestMapping("/hello"), you still can use class level mapping, but it's optional
public class HelloWorldController {

    @RequestMapping("/hello") //a must-set, also can be something like ("/hello/index")
    public ModelAndView hello(){ //method renamed, the original name is same as Constructor name, which is not recommended
        String message = "Good evening sir.";
        return new ModelAndView("hello", "message", message);
    }
}