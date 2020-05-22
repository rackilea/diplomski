@Controller    
public class MyController {

    @RequestMapping(value="/someurl", method=RequestMethod.GET)
    public String doStuff(@ModelAttribute("something") Something something, ModelMap map) {
        //do stuff
        // here you can do what you want with something it has been provided to you in the method parameters
        return "someurl";
    }

    @ModelAttribute("something")
    public Something something() {
        // do what you need
        return new Something();
    }
}