@Controller
public class DemoController {

    @RequestMapping(value="/**/versions/{versionId}", method = RequestMethod.GET)
    @ResponseBody
    public String version(@PathVariable String versionId){
        return "version " + versionId;
    }

    @RequestMapping(value="/**", method = RequestMethod.GET)
    @ResponseBody
    public String index(){
        return "index";
    }
}