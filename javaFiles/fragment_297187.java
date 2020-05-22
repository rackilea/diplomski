@ServerEndpoint(value = "/websocket/{key}", configurator = WebSocketConfig.class)
public class WebSocket {

    private static final Logger LOG = LoggerFactory.getLogger(WebSocket.class);

    public WebSocket() {
    }

    @OnOpen
    public void onOpen(Session session, @PathParam("key") String key) {
        LOG.info("OnOpen");
    }

    @OnClose
    public void onClose(Session session) {
        LOG.info("OnClose");
    }

    @OnMessage
    public void onMessage(String message, Session session){
        LOG.info("OnMessage: " + message);
    }
}