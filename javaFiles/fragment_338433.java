@Controller //please add this
public class URLController {

    @GetMapping({"/", "/index"})
    public String index1(Model model){
        model.addAttribute("employee",new Employee());
        return "index";
    }

    @PostMapping("/result")
    public String result(@ModelAttribute Employee employee){
        System.out.print(employee.getName()); //use a logger instead
        return "result"; //may want to return a different page name for clarity
    }
}