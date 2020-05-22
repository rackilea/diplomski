@Component
@Scope("prototype")
public class SingletonByDefaultBean {
    private StringBuilder responseBuilder;

    @Autowired
    private FooService fooService;

    public String methodUsedInSeveralThreads() {
        responseBuilder = new StringBuilder();
        //write contents into the response
        //...
        //return the response
        return responseBuilder.toString();
    }
}