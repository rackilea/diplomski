@Controller
@RequestMapping("/")
public class AnythingController{

    @RequestMapping(value="**",method = RequestMethod.GET)
    public String getAnything(){
        // your code
    }
}