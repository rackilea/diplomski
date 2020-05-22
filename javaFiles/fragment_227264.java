public class EchoHandler extends TextWebSocketHandler {

    private final CountDownLatch latch;

    public EchoHandler(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        System.out.println("------- received client message ------");
        System.out.println(message.getPayload());
        System.out.println("--------- end client message ---------");
        latch.countDown();
    }
}