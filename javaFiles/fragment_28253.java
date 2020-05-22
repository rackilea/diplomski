@Controller 
@RequestMapping(value="/test") 
public class TestController { 
    private String viewName = "newtest";

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    @RequestMapping(method=RequestMethod.GET) 
    public String getCreateForm(Model model) { 
        model.addAttribute(new AccountBean()); 
        return viewName; 
    } 
}