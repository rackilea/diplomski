@Configuration
static class LoggingCodecConfig {

    @Bean
    @Order(0)
    public CodecCustomizer loggingCodecCustomizer() {
        return (configurer) -> configurer.defaultCodecs()
                .enableLoggingRequestDetails(true);
    }

}