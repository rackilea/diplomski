@Controller
public class HomeController {
    @RequestMapping("/")
    public String home(Model model){
        String welcome = new String("Witam");
        model.addAttribute("welcome", welcome);
        return "home";
    }
}