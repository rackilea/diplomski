@Controller
public class AgeController {

    // this is to create an instance of Age and set in the model. 
    @RequestMapping("showForm")
    public String showForm(Model model) {
        model.addAttribute("age", new Age());
        return "form"; // return form page.
    }

    // this is to print the age in the display page.
    @RequestMapping("processForm")
    public String processForm(@ModelAttribute("age") Age age) {
        return "display"; // return display page where you will display the data populated in the form page.
    }

}