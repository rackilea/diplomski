@Controller
@SessionAttributes("myAdverts")
public class MyController {
    @RequestMapping(value="...", method=RequestMethod.GET)
    public void get(ModelMap model){
        List myAdverts = // get your list of adverts.
        model.put("myAdverts", myAdverts)
    }

    @RequestMapping(value="...", method=RequestMethod.POST)
    public void post(@RequestParam("position") final int position, @ModelAttribute("myAdverts") List myAdverts,SessionStatus sessionStatus){
        myAdverts.get(position);
        // ...

        // tell spring to remove myAdverts from session
        sessionStatus.setComplete();
    }
}