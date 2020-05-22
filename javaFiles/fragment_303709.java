@Bean
public IntegrationFlow httpOut() {
    return IntegrationFlows.from("inputChannel")
            .handle(Http.outboundGateway("http://localhost:8080/")
                    .charset("UTF-8")
                    .httpMethod(HttpMethod.POST)
                    .headerMapper(soapHeaderMapper())
                    .requestFactory(requestFactory()), e -> e.id("test"))
            .get();
}