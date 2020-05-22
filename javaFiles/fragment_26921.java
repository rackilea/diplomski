@Component
public class IntegrationService {
    @Autowired
    private ProducerTemplate producerTemplate;

    public void getServiceAuthentication() {
 producerTemplate.sendBody("direct:someservice","username=123&password=123");
    }
}