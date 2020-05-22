@Test
void test() {
    var host = "localhost";
    var endpoint = "/test";
    var port = 8089;
    var timeout = Duration.ofSeconds(3);

    WireMockServer wireMockServer = new WireMockServer(wireMockConfig().port(8089));
    wireMockServer.start();
    WireMock.configureFor(host, wireMockServer.port());

    WireMock.stubFor(get(urlEqualTo(endpoint))
        .willReturn(aResponse().withFixedDelay((int) timeout.toMillis())));

    HttpClient httpClient = HttpClient.create()
        .tcpConfiguration(client ->
            client.doOnConnected(conn -> conn
                .addHandlerLast(new ReadTimeoutHandler((int) (timeout.toSeconds() / 2)))
                .addHandlerLast(new WriteTimeoutHandler((int) (timeout.toSeconds() / 2)))));

    WebClient webClient = WebClient.builder()
        .baseUrl(format("http://%s:%d", host, port))
        .clientConnector(new ReactorClientHttpConnector(httpClient)).build();

    webClient.get().uri(endpoint).retrieve().bodyToMono(Recommendation.class).block();
}