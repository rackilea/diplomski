@Controller
public class MyController{

    @ModelAttribute
    public void getEmpRoles(Model model) {
        List<String> roles = myservice.loadEmpRoles();
        model.addAttribute(roles);
    }

    @RequestMapping(...)
    public String m1(Model model){
        // You roles model is available here
    }
}