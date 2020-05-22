@Controller
public class MyErrorController implements ErrorController {

  private static final String PATH = "/error";

  public MyErrorController() {}

  @RequestMapping(value = PATH)
  public ModelAndView handleAllException() {
    ModelAndView modelAndView = new ModelAndView("error_template");
    return modelAndView;
  }

  @Override
  public String getErrorPath () {
    System.out.println("-- Error Page GET --");
    return "error";
  }

}