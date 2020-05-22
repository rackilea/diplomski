@Component
public class SingletonByDefaultBean {
    private StringBuilder responseBuilder;

    @Autowired
    private FooService fooService;

    public String methodUsedInSeveralThreads() {
        //here you will have a concurrency issue
        responseBuilder = new StringBuilder();
        //write contents into the response
        //...
        //return the response
        return responseBuilder.toString();
    }
}