@Controller
public class TestController implements ApplicationContextAware{

    private ApplicationContext appContext;

    @RequestMapping(value="/handleGet",method=RequestMethod.GET)
    public String handleGet(ModelMap map){
        map.addAttribute("person", appContext.getBean("person"));
        return "test";
    }
    @RequestMapping(value="/handlePost",method=RequestMethod.POST)
    public @ResponseBody String handlePost(@ModelAttribute("person") Person person){
        return person.getDepartment().getDepartmentName();
    }

    @Override
    public void setApplicationContext(ApplicationContext appContext)
            throws BeansException {
        this.appContext=appContext;
    }
}