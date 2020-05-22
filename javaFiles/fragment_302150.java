@RestController
public class UserDetailService {

    @RequestMapping(value = "/res", method = RequestMethod.GET)
    public void getRes(
       @RequestParam(required = false, defaultValue = "value", value="param") final String param) {

         // param contains the value of the parameter in the URL

    }
}