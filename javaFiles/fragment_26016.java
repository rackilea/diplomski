@Component
public class ServerProperties
{
     @Value("${server.ip}");
     private String ipAddress;

     ...

     public void setIpAddress(String ipAddress)
     {
        this.ipAddress = ipAddress;
     }

     public String getIpAddress()
     {
        return this.ipAddress;
     }