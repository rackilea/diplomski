@SessionAttributes("model")
public class WebPageController {

  @ModelAttribute("model")
  @RequestMapping(method=RequestMethod.GET)
  public EntityA handleGet(Long id) {
    return entityService.getA(id);
  }

  @RequestMapping(method=RequestMethod.POST)
  public String handlePost(@ModelAttribute("model") EntityA a) {
    a.accessLazyField(); //will throw lazy load if the field was not accessed during original page rendering
    return "viewName";
  }
}