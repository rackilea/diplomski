@Controller
public class MyController() {

   @RequestMapping("/some.htm")
   public @ResponseBody Long someActionImpl() {
      // some business logic 
      return id;
   }

}