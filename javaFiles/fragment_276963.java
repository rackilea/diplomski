@Controller
public class MainController {

   @RequestMapping(value = "/home.html", method = RequestMethod.GET)
   public ModelAndView home() {
      return new ModelAndView("index");
   }

   @RequestMapping(value = "/dashboard.html")
   public ModelAndView dashboard() {
      return new ModelAndView("dashboard");
    }

   @RequestMapping(value = "/main.html")
   public ModelAndView main() {
      return new ModelAndView("main");
    }

  @RequestMapping(value = "/guided.html")
   public ModelAndView guided() {
      return new ModelAndView("guided");
    }

   @RequestMapping(value = "/unguided.html")
   public ModelAndView unguided() {
      return new ModelAndView("unguided");
    }


}