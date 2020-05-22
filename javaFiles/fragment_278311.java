@Controller
@RequestMapping(value="/{site}")
public class MyController {
  @RequestMapping(value="/blah/blah", method=RequestMethod.GET)
  public ModelAndView blahBlah(HttpServletRequest req,
                             HttpServletResponse resp,
                             @PathVariable("site") String site) {
     // do stuff here
  }
}