@Configuration
@ConfigurationProperties(prefix="config")
@EnableConfigurationProperties
public class GatewayConfig
{
    List<Gateway> gateways = new ArrayList<Gateway>();

    // Getter/Setter for gateways
    // ...

    public static class Gateway
    {
        private String id;
        private int nbrInputs;
        private int nbrOutputs;

        // Getters and Setters
        // ...
    }
}