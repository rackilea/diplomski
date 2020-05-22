final String testMessage = "test text message";
WebSocketSession session = mockWebSocketSession();

sender.sendStringMessage(session, testMessage).get(); // will wait here till operation completion

verify(session).sendMessage(new TextMessage(testMessage));