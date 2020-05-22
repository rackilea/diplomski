@Controller
public class HelloWorldController {

    @Autowired
    private MessageService _messageService; // -> new MessageServiceImpl1() or new MessageServiceImpl2() ...

    @RequestMapping("/helloWorld")
    public String helloWorld(Model model) {
        model.addAttribute("message", messageService.getMessage());
        return "helloWorld";
    }

}