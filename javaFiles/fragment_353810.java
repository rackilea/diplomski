@Bean
public RestTemplate restTemplate(
       RestTemplateBuilder restTemplateBuilder,
       final int serviceConnectionTimeout,
       final int serviceReadTimeout
        ) {
        return restTemplateBuilder
            .setConnectTimeout(serviceConnectionTimeout)
            .setReadTimeout(serviceReadTimeout)
            .build();
}