@Controller
@RequestMapping("/whatever")
public class DemoController() {

   @RequestMapping(params="x");
   public ModelAndView doX() {
   }

   @RequestMapping(params="y");
   public ModelAndView doY() {
   }
}