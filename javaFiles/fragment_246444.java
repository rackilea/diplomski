Mockito.verify(webSocketUtils).sendMessageToMultipleUsers(
//      [1]                    [6]
    messageCaptor.capture(),
//                [2]
    Matchers.eq(webSocket.getUserNameWebSocketSessions().get("user1")));
//           [5]          [3]                            [4]