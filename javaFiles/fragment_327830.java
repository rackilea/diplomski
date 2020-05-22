@Controller
@RequestMapping("test1")
public class TestController {
    public TestController() {}

    @RequestMapping(value="test2", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional("defaultTransactionManager")
    public String getSearch() {
        System.out.println("It reaches here!");
        return  "{\"resp\":\"Test Success\"}";
    }
}