@Configuration
public class ConfigurationA {

    @Bean
    @Qualifier("restTemplateA")
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        //setting some restTemplate properties

        return restTemplate;
    }
}

@Configuration
public class ConfigurationB {

    @Bean
    @Qualifier("restTemplateB")
    public RestTemplate restTemplateB() {
        RestTemplate restTemplate = new RestTemplate();

        //setting some restTemplate properties

        return restTemplate;
    }
}