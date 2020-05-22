private static final WireMockServer server = new WireMockServer(options().port(8080));

public static void main(String[] args) {
    server.stubFor(post(urlEqualTo("/localsave")).willReturn(aResponse().withStatus(HttpStatus.SC_OK)));
    server.start();
    //do some stuff
}