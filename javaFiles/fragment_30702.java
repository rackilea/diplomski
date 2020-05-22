@Controller
public class MyFormProcessor {
   @RequestMapping("/formsubmit")
   public String handleForm(@Valid Person person, BindingResult errors, Map<String,Object> model){
      // ...handle form...
   }
}