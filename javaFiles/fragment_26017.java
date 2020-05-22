@Component
public class ConfigureMe
{
    @AutoWired
    private ServerProperties serverProperties;

    @PostConstruct
    public void init()
    {
        if(serverProperties.getIpAddress().equals("localhost")
        {
            ...
        }
        else
        {
            ...
        }
    }
}