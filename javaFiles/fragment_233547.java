DefaultHttpHeaders headers = new DefaultHttpHeaders();
headers.add("Authorization", "Bearer e2238f3a-e43c-3f54-a05a-dd2e4bd4631f");
headers.add("websocket.custom.header.X-WS-UserName", "bob");

final WebSocketClientHandler handler = new WebSocketClientHandler(
                    WebSocketClientHandshakerFactory.newHandshaker(
                            uri, WebSocketVersion.V13, null, false, headers));