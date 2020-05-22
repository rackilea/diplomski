public static void main(String... args) throws Exception {
    final CountDownLatch latch = new CountDownLatch(1);
    EchoHandler handler = new EchoHandler(latch);
    WebSocketClient client = new StandardWebSocketClient();
    WebSocketSession session = client.doHandshake(handler, ECHO_URL).get();
    session.sendMessage(new TextMessage("Hello World"));
    latch.await(5000, TimeUnit.SECONDS);
    session.close();
}