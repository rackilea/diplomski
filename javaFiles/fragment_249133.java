testClient.get()
            .uri(path)
            .header("host", gatewayDns)
            .exchange()

nextRequestFromGateway {
    method `should equal` "CONNECT"
    headers[HOST] `should equal` "$realUrlBehindGateway:80"
}

nextRequestFromGateway {
    path `should equal` "/api/v1/whatever"
    headers[HOST] `should equal` realUrlBehindGateway
}

...
fun nextRequestFromGateway(block : RecordedRequest.() -> Unit) {
    mockWebServer.takeRequest().apply (block)
}