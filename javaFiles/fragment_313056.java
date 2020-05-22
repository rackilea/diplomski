@Controller
@SessionAttributes(value = {"user1", "user2"})
public class MyController {
    // ...

    @GetMapping("/page1")
    public String page1(ModelMap model){
        model.put("user", new User());
        return "page1";
    }

    @PostMapping("/page1")
    public String page1Post(@ModelAttribute("user") User user, ModelMap model{
        model.put("user1", user);
        model.put("user", new User());
        return "page2";
    }

    @PostMapping("/page2")
    public String page2Post(@ModelAttribute("user") User user, ModelMap model{
        model.put("user2", user);
        return "page3";
    }
}