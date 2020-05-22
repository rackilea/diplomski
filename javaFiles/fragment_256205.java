@WebSocket
public class ChatSocket {
    public ChatRoom chatroom;

    public ChatSocket(ChatRoom chatroom)
    {
        this.chatroom = chatroom;
    }

    @OnWebSocketConnect
    public void onConnect(Session session) {
        chatroom.join(this);
    }

    @OnWebSocketMessage
    public void onText(String message) {
        chatroom.writeAllMembers(message);
    }

    @OnWebSocketClose
    public void onClose(int statusCode, String reason) {
        chatroom.part(this);
    }
}

public class ChatCreator implements WebSocketCreator
{
    private ChatRoom chatroom;

    public ChatCreator(ChatRoom chatroom)
    {
        this.chatroom = chatroom;
    }

    public Object createWebSocket(UpgradeRequest request, 
                                  UpgradeResponse response)
    {
        // We want to create the Chat Socket and associate
        // it with our chatroom implementation
        return new ChatSocket(chatroom);
    }
}

public class ChatHandler extends WebSocketHandler
{
    private ChatRoom chatroom = new ChatRoom();

    @Override
    public void configure(WebSocketServletFactory factory)
    {
        factory.setCreator(new ChatCreator(chatroom));
    }
}