Collection<WebSocketSession> sessions =
    webSocket.getUserNameWebSocketSessions().get("user1");
//  [1]
Mockito.verify(webSocketUtils).sendMessageToMultipleUsers(
//      [2]                    [5]
    messageCaptor.capture(), Matchers.eq(sessions));
//                [3]                 [4]