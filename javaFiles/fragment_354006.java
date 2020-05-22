public class DiameterClient {
    @Autowired
    private List<DiameterMessageHandler> handlers;

    @Value("${pcca.host}")
    private String host;

    @Value("${pcca.port}")
    private int port; // or String...

    // I don't know what these other two would be...if they are autowired, or just values you would populate...
    private String somePackage;

    private String anotherPackage;

    // methods go here...
}