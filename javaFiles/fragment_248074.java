@Controller 
@RequestMapping("/test") 
public class SomeController {

    @Resource
    private SomeService someService;

    @PostConstruct
    public void postConstruct(){
        someService.serviceMethod();
    }
}