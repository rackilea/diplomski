@ServerEndpoint(value = "/ws/data")
public class ChatHandler {
    @OnOpen
    public void onOpen(Session session) {
        Map<String, List<String>> map = session.getRequestParameterMap();
        if (!map.containsKey("path")) {
            // TODO: throw exception
        }
        String path = map.get("path").get(0);
    }
}