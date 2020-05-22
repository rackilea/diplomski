@Controller
public class ExampleController {

    @ResponseBody
    @RequestMapping(value = "/path", method=RequestMethod.POST)
    public String post(@RequestParam String componentAction)  {
        // do work
        ...
        return "OK";  // depends on what you need to send back...
    }


}