public class WsClient {

public static void main(String[] args) throws InterruptedException {
    WebSocketClient client = new ReactorNettyWebSocketClient();     
    client.execute(URI.create("wss://echo.websocket.org"), 
            session -> session.send(Mono.just(
                    session.textMessage("{\"event\":\"ping\"}")))
            .thenMany(session
                      .receive()
                      .map(WebSocketMessage::getPayloadAsText)
                      .log())
                    .then()).block(Duration.ofSeconds(10));     
    System.out.println("End");
}

}