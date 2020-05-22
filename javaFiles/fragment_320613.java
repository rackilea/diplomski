@ServerEndpoint("/myendpoint")
public class MyEndpoint {
  @OnMessage
  public void onMessage(Session session, String message) {
    try {  
      for (Session s : session.getOpenSessions()) {
        if (s.isOpen()) {
          s.getBasicRemote().sendText(message);
        }
    } catch (IOException ex) { ... }
  } 
}