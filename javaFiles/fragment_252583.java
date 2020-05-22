@TestConfiguration
static class TestConfig {
    @Bean
    public RestTemplateBuilder restTemplateBuilder() {
        return new RestTemplateBuilder().detectRequestFactory(false).requestFactory(SimpleClientHttpRequestFactory.class);
    }
}