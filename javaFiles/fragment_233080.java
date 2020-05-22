@Controller
public class SecureListController {
    @RequestMapping(value={"/secure/list"}, method=RequestMethod.GET)
    public ModelAndView getSecureList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("listpage.html");
        return modelAndView;
    }    
}