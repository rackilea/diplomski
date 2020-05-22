Http.inboundGateway("/tunnel")
    .errorChannel("httpErrorFlow.input")
...

@Bean
public IntegrationFlow httpErrorFlow() {
    return f -> f
            .<RuntimeException, Message<?>>transform(payload -> {
                if (payload.getCause() instanceof MyRoutingKeyException) {
                    return MessageBuilder.withPayload("Bad routing key")
                            .setHeader(HttpHeaders.STATUS_CODE, HttpStatus.BAD_REQUEST)
                            .build();
                }
                throw payload;
            });
}