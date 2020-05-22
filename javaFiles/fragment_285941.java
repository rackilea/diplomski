public class AppRestTemplate extends RestTemplate {

    private final ApplicationPropertiesDataService applicationPropertiesDataService;

    @Autowired
    public AppRestTemplate(ApplicationPropertiesDataService applicationPropertiesDataService) {
        this.applicationPropertiesDataService = applicationPropertiesDataService;
    }
}