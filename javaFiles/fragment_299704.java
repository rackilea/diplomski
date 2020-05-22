@Controller
@RequestMapping("/something")
public class SomeController {
    @Autowired
    private BeanFactory beanFactory;

    @RequestMapping("/doStuff")
    public void login(@RequestParam("type") String type) {
        SomeService aService = (SomeService)beanFactory.getBean(type);
        aService.doStuff();
    }
}