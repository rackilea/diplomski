@ServerEndpoint(value = "/ws/data/{path}"
public SingleChatHandler : ChatHandler {
    @OnOpen
    public void onOpen(
        Session session,
        @PathParam("path") String path) {
        onOpenInternal(session, path);
    }
}
@ServerEndpoint(value = "/ws/data/{path1}/{path2}"
public DoubleChatHandler : ChatHandler {
    @OnOpen
    public void onOpen(
        Session session,
        @PathParam("path1") String path1,
        @PathParam("path2") String path2) {
        onOpenInternal(session, path1 + '/' + path2);
    }
}
public abstract class ChatHandler {
    protected void onOpenInternal(Session session, String path) { [...] }
}