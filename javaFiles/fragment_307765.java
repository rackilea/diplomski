class MyWebSocketRouter implements WebSocketHandler {

  final Map<String, EnumMap<ActionMessage.Type, ChannelHandler>> channelsMapping;


  @Override
  public Mono<Void> handle(WebSocketSession session) {
    final Map<String, Disposable> channelsIdsToDisposableMap = new HashMap<>();
    ...
  }
}