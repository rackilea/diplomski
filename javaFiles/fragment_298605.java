@Controller
public class KajmanController {
    @Autowired
    private KajmanInfoService kajmanInfoService;

    @RequestMapping(method = RequestMethod.GET)
    public String getInfo(@RequestParam(value="myParam[]") String[] myParams){
        //some logic
        for (String param : myParams) {
            Info info = kajmanInfoService.getInfo(param);
            //some logic
        }
        //some logic
    }
}