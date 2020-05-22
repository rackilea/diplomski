@RestController 
@RequestMapping(value = "/{username}")
public class RestController {

@RequestMapping(value = "/test", method = RequestMethod.GET)
public String test() {
return "Rest controller data.";
}

}