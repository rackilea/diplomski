@Controller
public class SelectController {

   private final class MyClass c = new MyClass();

   @RequestMapping(value="/select", method = RequestMethod.POST)
   public String doSelect(@RequestParam("selection") final String selection, final ModelMap model) {
       final String result = c.doSomething(selection);
       modelMap.addAttribute("result", result);

       return "yourJsp";
   }
}