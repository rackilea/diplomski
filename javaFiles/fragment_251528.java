private void initialize(Logger logger) {
    mTransports = new ArrayList<ClientTransport>();
    mTransports.add(new WebsocketTransport(logger));
    mTransports.add(new ServerSentEventsTransport(logger));
    mTransports.add(new LongPollingTransport(logger));
}