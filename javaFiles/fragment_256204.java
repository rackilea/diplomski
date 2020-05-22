@WebSocket
public class ChatSocket {
    public Session session;

    @OnWebSocketConnect
    public void onConnect(Session session) {
        this.session = session;
        ChatRoom.getInstance().join(this);
    }

    @OnWebSocketMessage
    public void onText(String message) {
        ChatRoom.getInstance().writeAllMembers("Hello all");
    }

    @OnWebSocketClose
    public void onClose(int statusCode, String reason) {
        ChatRoom.getInstance().part(this);
    }
}

public class ChatRoom {
    private static final ChatRoom INSTANCE = new ChatRoom();

    public static ChatRoom getInstance()
    {
        return INSTANCE;
    }

    private List<ChatSocket> members = new ArrayList<>();

    public void join(ChatSocket socket) 
    {
        members.add(socket);
    }

    public void part(ChatSocket socket) 
    {
        members.remove(socket);
    }

    public void writeAllMembers(String message) 
    {
        for(ChatSocket member: members)
        {
            member.session.getRemote().sendStringByFuture(message);
        }
    }

    public void writeSpecificMember(String memberName, String message) 
    {
        ChatSocket member = findMemberByName(memberName);
        member.session.getRemote().sendStringByFuture(message);
    }

    public ChatSocket findMemberByName(String memberName) 
    {
        // left as exercise to reader
    }
}