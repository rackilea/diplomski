@Component
public class MyServiceAdapter implements MyService {

    @Autowired
    private MyServiceOne myServiceOne;

    @Autowired
    private MyServiceTwo myServiceTwo;

    @Autowired
    private MyServiceThree myServiceThree;

    @Autowired
    private MyServiceDefault myServiceDefault;

    public boolean checkStatus(String service) {
        service = service.toLowerCase();

        if (service.equals("one")) {
            return myServiceOne.checkStatus();
        } else if (service.equals("two")) {
            return myServiceTwo.checkStatus();
        } else if (service.equals("three")) {
            return myServiceThree.checkStatus();
        } else {
            return myServiceDefault.checkStatus();
        }
    }
}