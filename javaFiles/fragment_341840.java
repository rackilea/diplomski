@Controller
public class YourController {
     ...
    @RequestMapping(value="/url")  
    public ModelAndView process(HttpSession session,...) {  
    ModelAndView modelAndView = new ModelAndView();  
    session.setAttribute("yourObj", yourObj);
    ...  
    return modelAndView;  
}  
}