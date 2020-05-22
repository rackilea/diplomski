@Controller
public class UpdateProperties
{

    @AutoWired
    private ServerProperties serverProperties;        

    @RequestMapping("/updateProperties")
    public String updateProperties()
    {
       serverProperties.setIpAddress(...);
       return "done";
}