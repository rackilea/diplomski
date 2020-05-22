@Controller
@RequestMapping("/module1/controller")
public class Module1Controller {

   // Define your specific HTTP RequestMapping 

   @RequestMapping(value = "/action.do", method = RequestMethod.GET)
   public String foo(HttpSerlvetRequest request, Map<String, Object> map)){

       // define your method behaviour
       return "sample";
   }
}