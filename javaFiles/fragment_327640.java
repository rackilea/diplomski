@Controller
@SessionAttributes({"priceIncrease"})
@RequestMapping("/priceIncrease")
public class MyController {

  @ModelAttribute("priceIncrease")
  public PriceIncrease createPriceIncrease() {
      PriceIncrease priceIncrease = new PriceIncrease();
      priceIncrease.setPercentage(20);
      return priceIncrease;
  }

  @RequestMapping(method={RequestMethod.POST})
  public ModelAndView post(@ModelAttribute("priceIncrease") PriceIncrease priceIncrease,
      HttpServletRequest request,
      HttpServletResponse response) {
     ...
  }

  @RequestMapping(method={RequestMethod.GET})
  public ModelAndView get(@ModelAttribute("priceIncrease") PriceIncrease priceIncrease,
      HttpServletRequest request,
      HttpServletResponse response) {
     ...
  }

}