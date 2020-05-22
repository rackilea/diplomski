@Autowired
RestTemplate restTemplate;

@Bean
public RestTemplate getRestTemplate() {
    return new RestTemplate();
}