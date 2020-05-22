container.setAdviceChain(new Advice[] {
        org.springframework.amqp.rabbit.config.RetryInterceptorBuilder
                .stateless()
                .maxAttempts(5)
                .backOffOptions(1000, 2, 5000)
                .build()
});