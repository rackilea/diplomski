@Bean
RSocket rSocket() {
    return RSocketFactory.connect()
            .mimeType(MetadataExtractor.ROUTING.toString(), MimeTypeUtils.APPLICATION_JSON_VALUE)
            .frameDecoder(PayloadDecoder.ZERO_COPY)
            .transport(TcpClientTransport.create(new InetSocketAddress(7500)))
            .start()
            .block();
}

@Bean
RSocketRequester requester(RSocketStrategies strategies) {
    return RSocketRequester.wrap(rSocket(), MimeTypeUtils.APPLICATION_JSON, MetadataExtractor.ROUTING, strategies);
}