@Component
public class MyServiceFactory {

    @Autowired
    private MyServiceOne myServiceOne;

    @Autowired
    private MyServiceTwo myServiceTwo;

    @Autowired
    private MyServiceThree myServiceThree;

    @Autowired
    private MyServiceDefault myServiceDefault;

    public static MyService getMyService(String service) {
        service = service.toLowerCase();

        if (service.equals("one")) {
            return myServiceOne;
        } else if (service.equals("two")) {
            return myServiceTwo;
        } else if (service.equals("three")) {
            return myServiceThree;
        } else {
            return myServiceDefault;
        }
    }
}