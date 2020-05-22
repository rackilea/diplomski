@Component
public class CustomMicroserviceMock {

    private WireMockServer wireMockServer;

    public CustomMicroserviceMock() {
        wireMockServer = new WireMockServer(options().port(1234));
        wireMockServer.stubFor(get(urlEqualTo("/yourendpoint"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "text/plain")
                        .withBody("Response")));
        wireMockServer.start();
    }


    @PreDestroy
    void preDestroy() {
        wireMockServer.stop();
    }

}