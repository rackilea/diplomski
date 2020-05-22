@Controller
@RequestMapping(value="/staff**")
public class StaffController extends BaseController {

    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView goStaffIndex(Model model) throws Exception{
        model.addAttribute("staff", new Staff());
        return new ModelAndView("staff/staffIndex","model",model);
    }

    @RequestMapping(value="/staff/newStaff**",method=RequestMethod.GET)
    public String addStaff(Model model) throws Exception{
        model.addAttribute("staff", new Staff());
        return "/staff/newStaff";            
    }
}