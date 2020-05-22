@Bean
    public RetryOperationsInterceptor configServerRetryInterceptor(RetryProperties properties) {
        return RetryInterceptorBuilder
                .stateless()
                .backOffOptions(properties.getInitialInterval(),
                        properties.getMultiplier(),
                        properties.getMaxInterval())
                .maxAttempts(properties.getMaxAttempts()).build();
    }