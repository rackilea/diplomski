@Controller
public class MyController {

    @Autowired
    private IMyService service;

    @RequestMapping(value = "/myPathName", method = RequestMethod.GET)
    public String home(HttpServletRequest request, Model model) {

        // you synchronized call
        service.callSynchronized(request, model); 

        return "someJsp";
    }

    // +edit
    @ResponseBody
    @RequestMapping(value = "/queueStatus", method = RequestMethod.GET)
    public String home(HttpServletRequest request) {

        // 
        return "inQueue: " + request.getAttribute("inQueue");
    }
}