@Configuration
@EnableConfigurationProperties(CSVProperties.class)
public class CSVExampleConfiguration {
    private final CSVProperties csvProperties;

    @Autowired
    public CSVExampleConfiguration(CSVProperties csvProperties) {
        this.csvProperties = csvProperties;
    }

    @Bean
    @Profile("!development")
    public MockData createProductionMockData() {
        return new MockData("production");
    }

    @Bean
    @Profile("development")
    public MockData createMockData() {
        return new MockData(csvProperties.getFirstCsv());
    }
}