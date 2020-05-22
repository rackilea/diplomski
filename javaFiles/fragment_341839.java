@Controller
@SessionAttributes("yourObj")
public class YourController {
     ...
    @RequestMapping(value="/url")  
    public ModelAndView process(...) {  
    ModelAndView modelAndView = new ModelAndView();  
    modelAndView.addObject("yourObj", new YourObject());  // this will put YourObj into session

    return modelAndView;  
}  
}