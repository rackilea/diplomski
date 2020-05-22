@Configuration
@EnableScheduling
public class SchedulerConfiguration {

    @Autowired
    private IntegrationService integrationService;

     @Scheduled(fixedDelay = 90000, initialDelay = 5000)
    public void integrationConfig() throws IOException {
        integrationService.getServiceAuthentication();

    }