http()
    .client(wiremockClient)
    .receive()
    .response(HttpStatus.OK)
    .messageType(MessageType.JSON)
    .payload(new ClassPathResource("classpath:validation/response_validation.json"))
;