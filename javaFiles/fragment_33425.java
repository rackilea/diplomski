@Configuration
@EnableConfigurationProperties({ConfigProperties.class})
@Controller
public class PropertyTest {

    @Autowired
    ConfigProperties config;


    @RequestMapping(value = "/dummy", method = RequestMethod.GET)
    @ResponseBody
    public void print() {
        // TODO Auto-generated method stub
        for(int i=0;i<config.getConfigNames().size();i++)
        System.out.println("Im in Property test method. :)" +config.getConfigNames().get(i)+" "+config.getConfigValues().get(i));
    }

}