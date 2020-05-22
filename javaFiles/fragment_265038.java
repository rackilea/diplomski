DefaultHttpHeaders httpHeaders = new DefaultHttpHeaders();
final WebSocketClientHandshaker handshaker = WebSocketClientHandshakerFactory.newHandshaker(uri, WebSocketVersion.V13, null, false, httpHeaders, 1280000);
final WebSocketClientHandler handler = new WebSocketClientHandler(handshaker, connection);
ChannelPipeline pipeline = ch.pipeline();
pipeline.addLast(new HttpClientCodec(),  new HttpObjectAggregator(65536));
pipeline.addLast("handler", handler);