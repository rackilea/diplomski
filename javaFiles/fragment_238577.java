@Controller
public class MyController {

    @GetMapping("/foo")
    public String showPage(Model model) {
        model.addAttribute("someBean", new SomeBean()); //assume SomeBean has a property called datePlanted
        return "foo";
    }

    @PostMapping("/foo")
    public String showPage(@ModelAttribute("someBean") SomeBean bean) {

        System.out.println("Date planted: " + bean.getDatePlanted()); //in reality, you'd use a logger instead :)
        return "redirect:someOtherPage";
    }    
}