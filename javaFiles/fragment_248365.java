public class SpringWebSocketHandler extends TextWebSocketHandler {

    private final Set<CommunicationObserver> observers = Sets.newConcurrentHashSet();

    @Autowired
    private MessageContext mc;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        Message msg = mc.parse(message.getPayload());

        for (CommunicationObserver o : observers) {
            o.packetReceived(session, msg);
        }
    }
}