@Controller
public class DefaultController {

   @RequestMapping(value = "/index.html", method = RequestMethod.POST)
   public String indexPure(ModelMap map, HttpServletRequest request) {

       final String zzz = request.getParameter("zzz");
       map.put("msg", "You sent [" + zzz + "]");
       return "index";
   }


   @RequestMapping(value = "/index.html", method = RequestMethod.GET)
   public String indexHTML(ModelMap map) {

       map.put("msg", "Please send something");
       return "index";
   }

}