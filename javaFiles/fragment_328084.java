@Controller 
public class HelloController {

    @Autowired
    private SomeFacade df;

    @RequestMapping(value = "/hello.htm", method = RequestMethod.GET)  
    public @ResponseBody String save() throws Exception {
        HibernateTemplate ht = df.getHibernateTemplate();
    }
}