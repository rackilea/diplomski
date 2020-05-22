@RestController
@Configuration
@PropertySource(value = "classpath:buildNumber.properties")
public class VersionProfiler extends AbstractController {

    @Value("${version}")
    private String ver;

    @RequestMapping(value="/version", method = RequestMethod.GET)
    public String getVersion(){
        return ver;
    }
}