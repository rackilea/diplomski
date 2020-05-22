@Controller
public class MyController{

    @RequestMapping("/my-mapping")
    public String showView(ModelMap model){
        model.addAttribute("varOne", someCondition?1:null);
        model.addAttribute("varTwo", someCondition?2:null);
        //etc ...
        return "view-name";
    }
}