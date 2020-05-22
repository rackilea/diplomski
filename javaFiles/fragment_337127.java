@Controller
public class GreetingController {

    private static final Map<String, Greeting> hashMap =  new ConcurrentHashMap<String, Greeting>();

    @RequestMapping(value="/greeting", method=RequestMethod.GET)
    public String greetingForm(Model model,  @RequestParam(value = "greetingId", required = false) Integer greetingId) {
        Greeting greeting = hashMap.get(greetingId)
                return greeting.getGreeting();
    }

    @RequestMapping(value = "/greeting", method = RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
        model.addAttribute("greeting", greeting);
        hashMap.put("1", greeting);
        return "result";
    }
}