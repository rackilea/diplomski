@Controller
public class MenuController {

    @RequestMapping( value="/customers", method = RequestMethod.GET)
    public ModelAndView listCustomers() {
        ModelAndView model = new ModelAndView("customers");
        model.addObject("list", "controller: a list of customers");
        return model;
    }
}