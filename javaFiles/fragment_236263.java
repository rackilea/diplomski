@Controller
@RequestMapping(value = "/welcome")
public class WelcomeController {
@RequestMapping(method = RequestMethod.GET)
public ModelAndView welcome() {
return new ModelAndView("productsHome");
}