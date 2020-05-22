@Override
public StompWebSocketEndpointRegistration addEndpoint(String... paths) {
    this.subProtocolWebSocketHandler.addProtocolHandler(this.stompHandler);
    WebMvcStompWebSocketEndpointRegistration registration =
            new WebMvcStompWebSocketEndpointRegistration(paths, this.webSocketHandler, this.sockJsScheduler);
    this.registrations.add(registration);
    return registration;
}