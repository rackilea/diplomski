@Component
public class ServerProperties
{

    @PreDestroy
    public void close()
    {
        ...Open file and write properties to server.properties.
    }
}