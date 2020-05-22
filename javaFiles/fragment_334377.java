@Controller
public class Controller {
    @Autowired private TestService testService;
    ...
    @RequestMapping
    public String returnPage() {
        ...
        testService.sediMigrate(); 
        ...
    }
}