@Service
public class TestController {
    @Autowired
    TestController(@Named("availabilityZone") Optional<Optional<String>> availabilityZone) {
        System.out.println(availabilityZone);
    }
}