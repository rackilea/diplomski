@Controller
public class CalcController {

  protected final Log logger = LogFactory.getLog(getClass());

  @Autowired
  private MyService myService;

  @RequestMapping(value = "calc", method = RequestMethod.GET)
  public String showCalcPage(
      @ModelAttribute("myModel") MyModel myModel,
      Model model, HttpServletRequest request) {

    // assemble page

    return "calc";
  }

  @RequestMapping(value = "calc/results")
  public String showResultsPage(
      @ModelAttribute("myModel") MyModel myModel,
      ModelMap model, final BindingResult bindingResult,
      HttpServletRequest request) {

    // assemble page

    // apply BindingResult validation in da fyoochoor
    myService.evaluate(myModel);
    model.addAttribute("myModel", myModel);

    return "results";
  }
}