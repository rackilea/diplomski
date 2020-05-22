@ConditionalOnProperty(prefix = "existing.property", value = "setup")
@ConditionalOnMissingBean
@Bean
Exchange exchange() {
    return ExchangeBuilder.topicExchange(properties.getExchange())
        .build();
}