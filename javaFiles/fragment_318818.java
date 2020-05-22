@Component
public class Gateway0{
    @Value("${config.gateways[0].id}")
    private String id;

    @Value("${config.gateways[0].nbrInputs}")
    private int numInputs;

    @Value("${config.gateways[0].nbrOutputs}")
    private int numOutputs;

    // Getters and Setters
    // ...
}